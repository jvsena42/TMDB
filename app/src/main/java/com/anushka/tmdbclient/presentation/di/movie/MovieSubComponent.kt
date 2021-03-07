package com.anushka.tmdbclient.presentation.di.movie

import com.anushka.tmdbclient.presentation.artist.ArtistActivity
import com.anushka.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

/*we will use this subcomponent to infect dependencies to artist activity*/

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}