package com.anushka.tmdbclient.data.domain.repository

import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.tvshow.TvShow

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}