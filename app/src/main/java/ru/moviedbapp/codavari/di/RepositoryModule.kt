package ru.moviedbapp.codavari.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.FlowPreview
import ru.moviedbapp.codavari.api.MovieApiService
import ru.moviedbapp.codavari.data.local.MovieDao
import ru.moviedbapp.codavari.data.repository.MovieRepository
import ru.moviedbapp.codavari.data.repository.MovieRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @FlowPreview
    @Provides
    @ActivityRetainedScoped
    fun provideMovieRepository(
        client: MovieApiService,
        dao: MovieDao
    ): MovieRepository {
        return MovieRepositoryImpl(client, dao)
    }
}