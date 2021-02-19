package com.anushka.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anushka.tmdbclient.data.model.tvshow.TvShow

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShow: List<TvShow>)

    @Query("DELETE FROM popular_tvShow")
    suspend fun deleteAllTVShows()

    @Query("SELECT * FROM popular_tvShow")
    suspend fun getTVShows( ): List<TvShow>
}