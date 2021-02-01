package com.anushka.tmdbclient.data.domain.usecase

import com.anushka.tmdbclient.data.domain.repository.MovieRepository
import com.anushka.tmdbclient.data.model.movie.Movie

class GetMoviesUseCase (private val movieRepository: MovieRepository){
    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}