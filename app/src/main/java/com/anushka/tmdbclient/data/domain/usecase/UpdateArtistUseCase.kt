package com.anushka.tmdbclient.data.domain.usecase

import com.anushka.tmdbclient.data.domain.repository.ArtistRepository
import com.anushka.tmdbclient.data.model.artist.Artist

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}