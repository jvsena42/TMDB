package com.anushka.tmdbclient.presentation.di.tvshow

import com.anushka.tmdbclient.domain.usecase.GetArtistUseCase
import com.anushka.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.anushka.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.anushka.tmdbclient.presentation.show.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

/*Provide artis viewmodel factory parameters*/

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase):TvShowViewModelFactory{
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}