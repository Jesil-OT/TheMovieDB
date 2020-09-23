package com.jesil.realproject.themoviedb.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.jesil.realproject.themoviedb.R
import com.jesil.realproject.themoviedb.adapter.RecyclerAdapter
import com.jesil.realproject.themoviedb.util.DataResult
import kotlinx.android.synthetic.main.movie_db_fragment.*

class MovieDbFragment : Fragment() {

    private val viewModel: MovieDbViewModel by viewModels()
    private val recyclerAdapter : RecyclerAdapter by lazy {
        RecyclerAdapter()
    }
    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.movie_db_fragment, container, false)

        recyclerView = view.findViewById(R.id.recyclerView_movieDb)



        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.dataResult.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataResult.Success -> {
                    recyclerAdapter.setMovieData(result.data!!.results)
                    recyclerView.adapter = recyclerAdapter
//                    Toast.makeText(requireContext(), result.data.results.toString(), Toast.LENGTH_SHORT).show()
                }
                is DataResult.Error -> {
                    Toast.makeText(requireContext(), result.error.localizedMessage, Toast.LENGTH_SHORT).show()
                    Log.d("MovieDbFragment", "error :${result.error.localizedMessage}")
                }
                is DataResult.Loading -> {
                    Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}