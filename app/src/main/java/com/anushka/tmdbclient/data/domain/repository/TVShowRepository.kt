package com.anushka.tmdbclient.data.domain.repository

import com.anushka.tmdbclient.data.model.tvshow.TvShow

interface TVShowRepository {
    suspend fun getTVShows(): List<TvShow>?
    suspend fun updateTVShows(): List<TvShow>?
}