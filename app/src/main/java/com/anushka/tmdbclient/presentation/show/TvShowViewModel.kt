package com.anushka.tmdbclient.presentation.show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.usecase.GetTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: GetTvShowsUseCase
):ViewModel() {

    fun getTvShows() = liveData{
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData{
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}