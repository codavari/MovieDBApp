package ru.moviedbapp.codavari.util


data class StateMessage(val response: Response)

data class Response(
    val message: String?,
    val uiComponentType: UIComponentType,
    val messageType: MessageType
)

sealed class UIComponentType{

    class Toast: UIComponentType()

    class Dialog: UIComponentType()

    class None: UIComponentType()
}

sealed class MessageType{

    class Error: MessageType()

    class None: MessageType()
}


interface StateMessageCallback{

    fun removeMessageFromStack()
}
