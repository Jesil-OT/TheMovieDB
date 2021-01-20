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
import com.jesil.realproject.themoviedb.util.DataResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.movie_db_fragment.*

@AndroidEntryPoint
class MovieDbFragment : Fragment(R.layout.movie_db_fragment) {

    private val viewModel: MovieDbViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }




}