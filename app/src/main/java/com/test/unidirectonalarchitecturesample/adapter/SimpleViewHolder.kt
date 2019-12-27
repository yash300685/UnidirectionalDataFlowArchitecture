package com.test.unidirectonalarchitecturesample.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.unidirectonalarchitecturesample.R
import com.test.unidirectonalarchitecturesample.models.Result

class SimpleViewHolder(v:View): RecyclerView.ViewHolder(v) {
    private var view: View = v

    fun bind(name: Result) {
     val  movieName=  view.findViewById<TextView>(R.id.movieName)
        val moviePoster=view.findViewById<ImageView>(R.id.moviepic)
        movieName.text = name.title
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+name.poster_path).resize(200, 200)
            .centerCrop().into(moviePoster)

    }

}