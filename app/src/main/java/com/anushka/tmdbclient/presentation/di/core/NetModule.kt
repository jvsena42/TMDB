package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {
    //Create a instance of retrofit service
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    //Create a instance of TBDMService
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit):TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}