package com.anushka.tmdbclient.data


import com.anushka.tmdbclient.data.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val movies: List<Movie>

)