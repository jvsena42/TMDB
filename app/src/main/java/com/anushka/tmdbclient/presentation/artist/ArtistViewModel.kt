package com.anushka.tmdbclient.presentation.artist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.usecase.GetArtistUseCase
import com.anushka.tmdbclient.domain.usecase.GetMoviesUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateMoviesUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
):ViewModel() {

    //Invoke execute function of get artists use case and emmit result list as live data
    fun getArtists() = liveData{
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData{
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}