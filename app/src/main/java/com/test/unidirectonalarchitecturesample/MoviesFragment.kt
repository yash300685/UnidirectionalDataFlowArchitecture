package com.test.unidirectonalarchitecturesample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import android.widget.Toast

import com.test.unidirectonalarchitecturesample.groupieItems.MovieItem
import com.test.unidirectonalarchitecturesample.viewmodels.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module
import com.test.unidirectonalarchitecturesample.state.MovieViewState
import com.xwray.groupie.GroupAdapter
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
    private val adapter by lazy { GroupAdapter<GroupieViewHolder>() }

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
                    for(movie in state.movieList )
                    adapter.add(MovieItem(movie,context))

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
