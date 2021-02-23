package com.anushka.tmdbclient.data.repository.artist

import android.util.Log
import com.anushka.tmdbclient.domain.repository.ArtistRepository
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.anushka.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    private suspend fun getArtistsFromApi():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null){
                artistList = body.artists
            }
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    private suspend fun getArtistsFromDB(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.isNotEmpty()){
            //Se a lista não for vazia, retorna ela
            return artistList
        }else{
            //Se a lista for vazia, recupera ela da API e salva no banco local
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    private suspend fun getArtistsCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.isNotEmpty()){
            //Se a lista não for vazia, retorna ela
            return artistList
        }else{
            //Se a lista for vazia, recupera ela do DB e salva no cache
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}