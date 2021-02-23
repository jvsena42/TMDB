package com.anushka.tmdbclient.data.repository.tvshow.datasourceImpl

import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.tvshow.TvShow
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import java.util.ArrayList

class TvShowCacheDataSourceImpl: TVShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }

}