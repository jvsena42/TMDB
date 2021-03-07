package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.anushka.tmdbclient.presentation.di.movie.MovieSubComponent
import com.anushka.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

/**
 * we can use singleton annotation to annotate Application component
 * and objects we want to reuse across the whole application
 */

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DataBaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {
    //Define functions to get subcomponent factories
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}