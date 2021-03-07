package com.anushka.tmdbclient.presentation.di.artist

import com.anushka.tmdbclient.domain.usecase.GetArtistUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.anushka.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

/*Provide artis viewmodel factory parameters*/

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase):ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )
    }

}