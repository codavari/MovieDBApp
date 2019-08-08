package ru.moviedbapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val mContext: Context, mData: ArrayList<Film>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private val mData: List<Film> = mData

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

        holder.title.text = mData[position].title
        holder.thumbnail.setImageResource(mData[position].thumbnail)
        holder.cardView.setOnClickListener {
            val intent = Intent(mContext, FilmActivity::class.java)
            // passing data to the book activity
            intent.putExtra("Title", mData[position].title)
            intent.putExtra("Description", mData[position].description)
            intent.putExtra("Thumbnail", mData[position].thumbnail)
            // start the activity
            mContext.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById<View>(R.id.film_title_id) as TextView
        var thumbnail: ImageView = itemView.findViewById<View>(R.id.film_img_id) as ImageView
        var cardView: CardView = itemView.findViewById<View>(R.id.cardview_id) as CardView
    }
}