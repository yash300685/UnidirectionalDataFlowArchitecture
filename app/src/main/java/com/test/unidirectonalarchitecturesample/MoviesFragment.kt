package com.test.unidirectonalarchitecturesample

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.test.unidirectonalarchitecturesample.adapter.SimpleMoviesAdapter

import com.test.unidirectonalarchitecturesample.dummy.DummyContent
import com.test.unidirectonalarchitecturesample.dummy.DummyContent.DummyItem
import com.test.unidirectonalarchitecturesample.models.MovieModel
import com.test.unidirectonalarchitecturesample.network.Status
import com.test.unidirectonalarchitecturesample.viewmodels.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module
import com.test.unidirectonalarchitecturesample.network.Result
import com.test.unidirectonalarchitecturesample.state.MovieViewState
import io.uniflow.androidx.flow.onStates
import kotlinx.android.synthetic.main.fragment_item_list.*


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [MoviesFragment.OnListFragmentInteractionListener] interface.
 */

val fragmentModule = module {
    factory { MoviesFragment() }
}
class MoviesFragment : Fragment() {

    private val movieViewModel: MovieViewModel by viewModel()
    private val adapter = SimpleMoviesAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_list, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieList.layoutManager=LinearLayoutManager(activity)
        movieList.adapter= adapter
        movieViewModel.getMovies()
        onStates(movieViewModel) { state ->
            when (state) {
                is MovieViewState.Movie -> {
                    movieViewModel.stopLoading()
                    adapter.updateMovies(state.movieList)
                }
                is MovieViewState.Loading ->
                    if(state.isLoading)
                {
                    progress_bar.visibility=View.VISIBLE
                }
                else
                    {
                        progress_bar.visibility=View.GONE
                    }

                is MovieViewState.Failed -> {
                    movieViewModel.stopLoading()
                    Toast.makeText(this.context,state.error,Toast.LENGTH_LONG).show()
                }




            }
        }

    }




}
