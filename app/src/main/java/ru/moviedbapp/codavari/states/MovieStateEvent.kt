package ru.moviedbapp.codavari.states

import ru.moviedbapp.codavari.util.StateEvent

sealed class MovieStateEvent : StateEvent {

    object NowPlayingEvent : MovieStateEvent() {
        override fun errorInfo(): String {
            return "Error getting now playing movies"
        }
        override fun toString(): String {
            return "NowPlayingEvent"
        }
    }

    object MovieDetailEvent : MovieStateEvent() {
        override fun errorInfo(): String {
            return "error returning movie detail"
        }
        override fun toString(): String {
            return "MovieDetailEvent"
        }
    }

    class None : MovieStateEvent() {
        override fun errorInfo(): String {
            return "None."
        }
    }
}