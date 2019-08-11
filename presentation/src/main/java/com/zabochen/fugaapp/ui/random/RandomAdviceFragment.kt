package com.zabochen.fugaapp.ui.random

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.zabochen.doman.model.Advice
import com.zabochen.fugaapp.MainApp
import com.zabochen.fugaapp.R
import com.zabochen.fugaapp.factory.ViewModelFactory
import com.zabochen.fugaapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_advice_random.*
import javax.inject.Inject

class RandomAdviceFragment : BaseFragment(R.layout.fragment_advice_random) {

    @Inject
    lateinit var randomAdviceViewModelFactory: ViewModelFactory<RandomAdviceViewModel>

    private val randomAdviceViewModel by viewModels<RandomAdviceViewModel> { randomAdviceViewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.appComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ViewModel
        this.randomAdviceViewModel.apply {

            this.randomAdvice.observe(viewLifecycleOwner, Observer { advice ->
                showRandomAdvice(advice)
            })

            this.dataLoading.observe(viewLifecycleOwner, Observer { loadingState ->
                showLoading(loadingState)
            })

            this.dataLoadingError.observe(viewLifecycleOwner, Observer { event ->
                event.getContentIfNotHandled()?.let { errorMessage ->
                    showError(errorMessage)
                }
            })

            this.dataRefreshLoading.observe(viewLifecycleOwner, Observer { refreshLoadingState ->
                showRefreshLoading(refreshLoadingState)
            })
        }

        // Refresh
        fragmentAdviceRandom_swipeRefreshLayout.setOnRefreshListener {
            this.randomAdviceViewModel.loadData(refreshState = true)
        }
    }

    private fun showRandomAdvice(advice: Advice) {
        fragmentAdviceRandom_textView_randomAdvice.text = advice.text
    }

    private fun showLoading(loadingState: Boolean) {
        if (loadingState) {
            fragmentAdviceRandom_group_content.visibility = View.GONE
            fragmentAdviceRandom_group_loading.visibility = View.VISIBLE
        } else {
            fragmentAdviceRandom_group_content.visibility = View.VISIBLE
            fragmentAdviceRandom_group_loading.visibility = View.GONE
        }
    }

    private fun showRefreshLoading(refreshLoadingState: Boolean) {
        fragmentAdviceRandom_swipeRefreshLayout.isRefreshing = refreshLoadingState
    }

    private fun showError(errorMessage: String) {
        Snackbar.make(activity!!.findViewById(android.R.id.content), errorMessage, Snackbar.LENGTH_LONG)
            .show()
    }
}