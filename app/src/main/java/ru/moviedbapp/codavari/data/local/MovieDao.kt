package ru.moviedbapp.codavari.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.moviedbapp.codavari.models.entity.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(Movie: Movie): Long

    @Insert(onConflict = REPLACE)
    suspend fun insertList(movies: List<Movie>)

    @Delete
    suspend fun delete(Movie: Movie)

    @Query("SELECT * FROM movies")
    suspend fun getMovies(): List<Movie>

    @Query("SELECT * FROM movies WHERE id= :movieId")
    suspend fun getMovie(movieId: Int): Movie

}