package ru.moviedbapp.codavari.states

import kotlinx.coroutines.flow.Flow
import ru.moviedbapp.codavari.models.entity.Movie

interface MovieContract {
    interface ViewState {
        fun intents(): Flow<ViewIntent>
    }

    sealed class MovieStateEvent {

        object NowPlayingEvent : MovieStateEvent() {
            fun errorInfo(): String {
                return "Error getting now playing movies"
            }

            override fun toString(): String {
                return "NowPlayingEvent"
            }


        }

        object MovieDetailEvent : MovieStateEvent() {

            fun errorInfo(): String {
                return "error returning movie detail"
            }

            override fun toString(): String {
                return "MovieDetailEvent"
            }

        }

        object None : MovieStateEvent() {
            fun errorInfo(): String {
                return "None"
            }

        }

    }

    sealed class ViewIntent {
        object Initial : ViewIntent()
        object Refresh : ViewIntent()
        object Retry : ViewIntent()
        data class RateMovie(val user: Movie) : ViewIntent()
    }
}