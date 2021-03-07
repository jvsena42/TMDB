package com.anushka.tmdbclient.domain.repository

import com.anushka.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTVShows(): List<TvShow>?
    suspend fun updateTVShows(): List<TvShow>?
}