package com.example.bottomnavview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavview.databinding.ItemMovieBinding
import com.example.bottomnavview.model.Movie

class MovieAdapter (val listOfMovies : List<Movie>,val context : Context):RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = listOfMovies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitle.text = listOfMovies[position].name
        holder.movieType.text = listOfMovies[position].type
        Glide.with(context).load(listOfMovies[position].image).into(holder.movieImg)
    }
}

class MovieViewHolder(itemMovieBinding: ItemMovieBinding) : RecyclerView.ViewHolder(itemMovieBinding.root){
    val movieTitle = itemMovieBinding.movieTitle
    val movieImg = itemMovieBinding.img1
    val movieType = itemMovieBinding.movieType
}