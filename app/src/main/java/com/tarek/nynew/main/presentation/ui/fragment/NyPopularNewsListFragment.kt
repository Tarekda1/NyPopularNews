package com.tarek.nynew.main.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tarek.nynew.R
import com.tarek.nynew.core.Status
import com.tarek.nynew.core.presentation.ViewModelFactory
import com.tarek.nynew.main.data.model.NewsResponseModel
import com.tarek.nynew.main.data.model.response.NyPopularNewsResponse
import com.tarek.nynew.main.presentation.ui.adapter.NyNewsPopularListAdapter
import com.tarek.nynew.main.presentation.viewmodel.NyNewsViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_nynews_list.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NyPopularNewsListFragment : DaggerFragment() {

    private var nyNewAdapter: NyNewsPopularListAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var viewModel: NyNewsViewModel? = null

    private val newPosition = HashMap<String, Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nynews_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        activity?.title = getString(R.string.news_list)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity(), viewModelFactory)
            .get(NyNewsViewModel::class.java)
        viewModel?.getAllNyPopularNewsLiveData()?.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.LOADING -> showLoading()
                Status.ERROR -> dismissLoading()
                Status.SUCCESS -> {
                    dismissLoading()
                    it.data?.let { listNews -> populateNewsList(listNews) }

                }
            }
        })
        viewModel?.requestPopularNyNewsList()
    }

    private fun populateNewsList(resp: NyPopularNewsResponse) {
        val llm = LinearLayoutManager(activity)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerview.layoutManager = llm
        nyNewAdapter = activity?.let { NyNewsPopularListAdapter(it, resp.results!!) }
        recyclerview.adapter = nyNewAdapter
    }

    private fun dismissLoading() {
        loader.visibility = View.GONE
    }

    private fun showLoading() {
        loader.visibility = View.VISIBLE
    }
}