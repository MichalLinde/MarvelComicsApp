package com.mlinde.marvelcomicsapp.comicsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlinde.marvelcomicsapp.GlideApp
import com.mlinde.marvelcomicsapp.data.ComicBook
import com.mlinde.marvelcomicsapp.databinding.ComicsListElementBinding

class ComicsListAdapter(
    private val comics: List<ComicBook>,
    private val onClick: (comicBook: ComicBook) -> Unit)
    : RecyclerView.Adapter<ComicsListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComicsListAdapter.ViewHolder {
        val binding = ComicsListElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicsListAdapter.ViewHolder, position: Int) {
        holder.bind(comics[position], onClick)
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    class ViewHolder(private val binding: ComicsListElementBinding)
        : RecyclerView.ViewHolder(binding.root){

            fun bind(comicBook: ComicBook, onClick: (comicBook: ComicBook) -> Unit) = with(binding){

                GlideApp.with(itemView)
                    .load(comicBook.thumbnail.getPath())
                    .into(binding.comicBookCover)


                binding.comicBookTitle.text = comicBook.title
                if (comicBook.description == null || comicBook.description == ""){
                    binding.comicBookDescription.text = "Description not given."

                } else{
                    if (comicBook.description.length > 80)
                        binding.comicBookDescription.text = comicBook.description.substring(0, 80)+"..."
                }
                if (comicBook.creators.items.isEmpty()){
                    binding.comicBookAuthor.text = "Author not given."
                } else{
                    var foundWriter = false
                    for (creator in comicBook.creators.items){
                        if (creator.role == "writer"){
                            binding.comicBookAuthor.text = "Written by ${creator.name}"
                            foundWriter = true
                            break
                        }
                    }
                    if (!foundWriter){
                        binding.comicBookAuthor.text = "Created by ${comicBook.creators.items[0].name}"
                    }
                }

                itemView.setOnClickListener {
                    onClick(comicBook)
                }

            }
        }
}