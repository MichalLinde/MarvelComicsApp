package com.mlinde.marvelcomicsapp.comicsList

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mlinde.marvelcomicsapp.data.ComicDataWrapper
import com.mlinde.marvelcomicsapp.databinding.FragmentComicsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsListFragment : Fragment() {


    private lateinit var binding: FragmentComicsListBinding
    private lateinit var viewModel: ComicsListViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentComicsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentComicsListBinding.bind(view)

        setUpComponents()
    }

    private fun setUpAdapter(it: ComicDataWrapper){
        binding.comicsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ComicsListAdapter(it.comicDataContainer.results)
        }
    }

    private fun setUpObserver(){
        viewModel.comicsLiveData.observe(viewLifecycleOwner){
            it?.let { 
                setUpAdapter(it)
            }
        }
    }

    private fun setUpComponents(){
        viewModel = ViewModelProvider(this).get(ComicsListViewModel::class.java)
        setUpObserver()
        viewModel.getComics()
    }
}