package com.mlinde.marvelcomicsapp.searchList

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlinde.marvelcomicsapp.GlideApp
import com.mlinde.marvelcomicsapp.comicsList.ComicsListAdapter
import com.mlinde.marvelcomicsapp.data.ComicBook
import com.mlinde.marvelcomicsapp.databinding.ComicsListElementBinding

class SearchListAdapter(private val comics: List<ComicBook>)
    :RecyclerView.Adapter<SearchListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchListAdapter.ViewHolder {
        val binding = ComicsListElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchListAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchListAdapter.ViewHolder, position: Int) {
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

            } else if (comicBook.description.toCharArray().count() > 50){
                binding.comicBookDescription.text = "${comicBook.description.slice(0..50)}..."
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