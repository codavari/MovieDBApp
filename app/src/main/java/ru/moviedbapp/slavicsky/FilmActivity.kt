package ru.moviedbapp.slavicsky

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_film.*
import ru.moviedbapp.R

class FilmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)

        val tvtitle = title_text
        val description = description_text
        val rating = rating
        val img = thumbnail

        // Receive data
        val intent = intent
        val title = intent.extras!!.getString("Title")
        val image = intent.extras!!.getInt("Thumbnail")

        // Setting values
        tvtitle.text = title
        description.text = intent.extras!!.getString("description")
        rating.text = intent.extras!!.getDouble("rating").toString()
        img.setImageResource(image)
    }
}