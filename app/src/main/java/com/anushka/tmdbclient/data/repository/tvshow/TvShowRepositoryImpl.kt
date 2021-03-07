package com.anushka.tmdbclient.data.repository.tvshow

import android.util.Log
import com.anushka.tmdbclient.domain.repository.TvShowRepository
import com.anushka.tmdbclient.data.model.tvshow.TvShow
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTVShows(): List<TvShow>? {
        //Cache -> Banco local - API
        return getShowsFromCache()
    }

    override suspend fun updateTVShows(): List<TvShow>? {
        val newLisOfShows = getShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveShowsToDB(newLisOfShows)
        tvShowCacheDataSource.saveShowsToCache(newLisOfShows)
        return newLisOfShows
    }

    private suspend fun getShowsFromAPI():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getShows()
            val body = response.body()
            if (body != null){
                tvShowList = body.tvShows
            }
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowList
    }

    private suspend fun getShowsFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getShowsFromDB()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()){
            //Se a lista não for vazia, retorna ela
            return tvShowList
        }else{
            //Se a lista for vazia, recupera ela da API e salva no banco local
            tvShowList = getShowsFromAPI()
            tvShowLocalDataSource.saveShowsToDB(tvShowList)
        }
        return tvShowList
    }

    private suspend fun getShowsFromCache():List<TvShow>{
        lateinit var tvShowList:List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getShowsFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()){
            //Se a lista não for vazia, retorna ela
            return tvShowList
        }else{
            //Se a lista for vazia, recupera ela do DB e salva no cache
            tvShowList = getShowsFromDB()
            tvShowCacheDataSource.saveShowsToCache(tvShowList)
        }
        return tvShowList
    }
}