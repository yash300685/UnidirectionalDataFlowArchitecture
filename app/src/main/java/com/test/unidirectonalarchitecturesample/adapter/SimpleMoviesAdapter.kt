package com.test.unidirectonalarchitecturesample.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.test.unidirectonalarchitecturesample.R
import com.test.unidirectonalarchitecturesample.models.Result

class SimpleMoviesAdapter(var movies: ArrayList<Result>): Adapter<SimpleViewHolder>() {
    val data=movies
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
       val inflatedView= LayoutInflater.from(parent.context).inflate(R.layout.movielist, parent, false)

        return SimpleViewHolder(inflatedView)

    }

    fun updateMovies(movies: List<Result>) {
        data.clear()
        data.addAll(movies)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
      return data.size
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.bind(data[position])

    }
}