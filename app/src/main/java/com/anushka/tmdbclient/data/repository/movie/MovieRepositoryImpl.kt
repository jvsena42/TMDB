package com.anushka.tmdbclient.data.repository.movie

import android.util.Log
import com.anushka.tmdbclient.domain.repository.MovieRepository
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        //Cache -> Banco local - API
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newLisOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newLisOfMovies)
        movieCacheDataSource.saveMoviesToCache(newLisOfMovies)
        return newLisOfMovies
    }

    private suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null){
                movieList = body.movies
            }
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }

    private suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList:List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.isNotEmpty()){
            //Se a lista não for vazia, retorna ela
            return movieList
        }else{
            //Se a lista for vazia, recupera ela da API e salva no banco local
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.isNotEmpty()){
            //Se a lista não for vazia, retorna ela
            return movieList
        }else{
            //Se a lista for vazia, recupera ela do DB e salva no cache
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}