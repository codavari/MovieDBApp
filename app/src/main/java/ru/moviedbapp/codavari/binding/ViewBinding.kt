package ru.moviedbapp.codavari.binding

import android.view.View
import androidx.databinding.BindingAdapter
import ru.moviedbapp.codavari.extensions.gone

@BindingAdapter("gone")
fun bindGone(view: View, shouldBeGone: Boolean) {
    view.gone(shouldBeGone)
}