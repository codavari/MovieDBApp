package ru.moviedbapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_image.*
import kotlinx.android.synthetic.main.activity_film.*
import kotlinx.android.synthetic.main.activity_film.txt_Cat
import kotlinx.android.synthetic.main.activity_film.txt_Desc

class FilmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)

        val tvtitle = title_text
        val tvdescription = txt_Desc
        val tvcategory = txt_Cat
        val img = thumbnail

        // Recieve data
        val intent = intent
        val title = intent.extras!!.getString("Title")
        val description = intent.extras!!.getString("Description")
        val image = intent.extras!!.getInt("Thumbnail")

        val imageAdapter = ImageAdapter(this)
        val detailImageView = detail_imageView
        val position = intent.extras!!.getInt("position")
        // Setting values

        tvtitle.text = title
        tvdescription.text = description
        img.setImageResource(image)

        Picasso.get()
            .load(imageAdapter.imageUrls[position]).placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .fit()
            .centerInside()
            .into(detailImageView)
    }
}