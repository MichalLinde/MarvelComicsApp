package com.mlinde.marvelcomicsapp.comicsList

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mlinde.marvelcomicsapp.GlideApp
import com.mlinde.marvelcomicsapp.data.ComicBook
import com.mlinde.marvelcomicsapp.databinding.ComicsListElementBinding

class ComicsListAdapter(private val comics: List<ComicBook>)
    : RecyclerView.Adapter<ComicsListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComicsListAdapter.ViewHolder {
        val binding = ComicsListElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicsListAdapter.ViewHolder, position: Int) {
        holder.bind(comics[position])
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    class ViewHolder(private val binding: ComicsListElementBinding)
        : RecyclerView.ViewHolder(binding.root){

            fun bind(comicBook: ComicBook){

                GlideApp.with(itemView)
                    .load(comicBook.thumbnail.getPath())
                    .into(binding.comicBookCover)


                binding.comicBookTitle.text = comicBook.title
                if (comicBook.description == null || comicBook.description == ""){
                    binding.comicBookDescription.text = "Description not given."

                } else{
                    binding.comicBookDescription.text = comicBook.description
                }
                for (creator in comicBook.creators.items){
                    if (creator.role == "writer"){
                        binding.comicBookAuthor.text = "Written by ${comicBook.creators.items[0].name}"
                        break
                    }
                }

            }
        }
}