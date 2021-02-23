package com.anushka.tmdbclient.domain.usecase

import com.anushka.tmdbclient.domain.repository.TVShowRepository
import com.anushka.tmdbclient.data.model.tvshow.TvShow

class UpdateTVShows(private val tvShowRepository: TVShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.updateTVShows()
}