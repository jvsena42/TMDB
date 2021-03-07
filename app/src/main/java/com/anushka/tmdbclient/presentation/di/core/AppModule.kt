package com.anushka.tmdbclient.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * provides the application context dependence
 */

@Module
class AppModule(private val context:Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }

}