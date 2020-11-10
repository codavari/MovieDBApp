package ru.moviedbapp.codavari.view

import ru.moviedbapp.codavari.util.Response
import ru.moviedbapp.codavari.util.StateMessageCallback

interface UICommunicationListener {

    fun onResponseReceived(
        response: Response,
        stateMessageCallback: StateMessageCallback
    )

    fun displayProgressBar(isLoading: Boolean)

    fun expandAppBar()

}