package ru.moviedbapp.codavari.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.moviedbapp.codavari.dispatchers.CoroutineDispatchers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoroutineDispatchersImpl @Inject constructor() : CoroutineDispatchers {
  override val main: CoroutineDispatcher = Dispatchers.Main
  override val io: CoroutineDispatcher = Dispatchers.IO
}