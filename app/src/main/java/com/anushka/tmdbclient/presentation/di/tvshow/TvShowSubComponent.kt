package com.anushka.tmdbclient.presentation.di.tvshow

import com.anushka.tmdbclient.presentation.artist.ArtistActivity
import com.anushka.tmdbclient.presentation.show.TvShowActivity
import dagger.Subcomponent

/*we will use this subcomponent to infect dependencies to tv show activity*/

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}