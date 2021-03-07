package com.anushka.tmdbclient.domain.usecase

import com.anushka.tmdbclient.domain.repository.TvShowRepository
import com.anushka.tmdbclient.data.model.tvshow.TvShow

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.updateTVShows()
}