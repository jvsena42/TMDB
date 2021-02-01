package com.anushka.tmdbclient.data.domain.usecase

import com.anushka.tmdbclient.data.domain.repository.TVShowRepository
import com.anushka.tmdbclient.data.model.tvshow.TvShow

class GetTVShowsUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTVShows()
}