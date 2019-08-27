package ru.moviedbapp.slavicsky

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ru.moviedbapp.R
import ru.moviedbapp.slavicsky.data.Movie
import ru.moviedbapp.slavicsky.data.MovieResponse

class RecyclerViewAdapter(private val mContext: Context, mData: ArrayList<MovieResponse>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private val mData: List<MovieResponse> = mData

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view: View
            val mInflater = LayoutInflater.from(mContext)
            view = mInflater.inflate(R.layout.cardview_film, parent, false)
            return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById<View>(R.id.film_title_id) as TextView
        var thumbnail: ImageView = itemView.findViewById<View>(R.id.film_img_id) as ImageView
        var cardView: CardView = itemView.findViewById<View>(R.id.cardview_id) as CardView
    }
}