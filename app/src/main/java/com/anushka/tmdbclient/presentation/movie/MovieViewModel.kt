package com.anushka.tmdbclient.presentation.movie

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.usecase.GetMoviesUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
):ViewModel() {

    //Invoke execute function of get movies use case and emmit result list as live data
    fun getMovies() = liveData{
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData{
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}