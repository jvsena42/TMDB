package com.anushka.tmdbclient.presentation.di.movie

import com.anushka.tmdbclient.domain.usecase.GetArtistUseCase
import com.anushka.tmdbclient.domain.usecase.GetMoviesUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.anushka.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.anushka.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

/*Provide artis viewmodel factory parameters*/

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase):MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }

}