package com.anushka.tmdbclient.data.repository.tvshow.datasource

import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.tvshow.TvShow

interface TVShowCacheDataSource {
    suspend fun getShowsFromCache():List<TvShow>
    suspend fun saveShowsToCache(tvShows:List<TvShow>)
}