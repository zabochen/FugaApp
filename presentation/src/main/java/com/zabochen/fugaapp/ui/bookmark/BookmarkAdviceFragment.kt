package com.zabochen.fugaapp.ui.bookmark

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.zabochen.doman.model.Advice
import com.zabochen.fugaapp.MainApp
import com.zabochen.fugaapp.R
import com.zabochen.fugaapp.factory.ViewModelFactory
import com.zabochen.fugaapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_advice_bookmark.*
import javax.inject.Inject

class BookmarkAdviceFragment : BaseFragment(R.layout.fragment_advice_bookmark) {

    @Inject
    lateinit var bookmarkViewModeFactory: ViewModelFactory<BookmarkAdviceViewModel>

    private val bookmarkViewModel by viewModels<BookmarkAdviceViewModel> { bookmarkViewModeFactory }

    private val bookmarkAdviceAdapter: BookmarkAdviceAdapter by lazy {
        BookmarkAdviceAdapter { advice ->
            clickItem(advice)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.appComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView & Adapter
        fragmentAdviceBookmark_recyclerView.apply {
            layoutManager = LinearLayoutManager(activity!!.applicationContext)
            adapter = bookmarkAdviceAdapter
        }

        bookmarkViewModel.bookmarkAdviceList.observe(viewLifecycleOwner, Observer { bookmarkAdviceList ->
            bookmarkAdviceAdapter.submitList(bookmarkAdviceList)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentAdviceBookmark_recyclerView.adapter = null
    }

    private fun clickItem(adviceItem: Advice) {
        Toast.makeText(
            activity!!.applicationContext,
            "ID: ${adviceItem.id}, TEXT: ${adviceItem.text}",
            Toast.LENGTH_LONG
        ).show()
    }
}