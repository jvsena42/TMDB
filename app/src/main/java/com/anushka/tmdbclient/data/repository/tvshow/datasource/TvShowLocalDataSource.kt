package com.anushka.tmdbclient.data.repository.tvshow.datasource

import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getShowsFromDB():List<TvShow>
    suspend fun saveShowsToDB(shows:List<TvShow>)
    suspend fun clearAll()
}