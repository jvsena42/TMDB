package com.anushka.tmdbclient.domain.usecase

import com.anushka.tmdbclient.domain.repository.ArtistRepository
import com.anushka.tmdbclient.data.model.artist.Artist

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}