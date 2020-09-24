package ru.moviedbapp.codavari.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

import ru.moviedbapp.codavari.models.entity.Movie


@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        const val DATABASE_NAME: String = "movies"
    }
}