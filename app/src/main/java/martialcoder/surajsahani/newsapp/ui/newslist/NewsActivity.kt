package martialcoder.surajsahani.newsapp.ui.newslist

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import martialcoder.surajsahani.newsapp.adapter.NewsArticlesAdapter
import martialcoder.surajsahani.newsapp.ui.base.BaseActivity
import martialcoder.surajsahani.newsapp.utils.getViewModel
import martialcoder.surajsahani.newsapp.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_layout.*
import kotlinx.android.synthetic.main.progress_layout.*
import martialcoder.surajsahani.newsapp.R
import martialcoder.surajsahani.newsapp.utils.observe

class NewsActivity : BaseActivity() {

    private val newsViewModel by lazy { getViewModel<NewsViewModel>() }

    private val adapter by lazy {
        NewsArticlesAdapter {

            val changePage = Intent(this, WebViewActivity::class.java)
            startActivity(changePage)
            toast("Clicked on item")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cosmetic setup for list
        setupList()

        // Observe for state changes
        newsViewModel.observableState.observe(this) { state ->
            renderState(state)
        }

        // Dispatch initial action to load news
        newsViewModel.dispatch(Action.LoadNews)
    }

    private fun setupList() {
        newsList.setEmptyView(emptyView)
        newsList.setProgressView(progressView)

        newsList.adapter = adapter
        newsList.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Update the UI based upon the [state]
     */
    private fun renderState(state: State) {
        when (state) {
            is State.News
            -> adapter.replaceItems(state.news)
            is State.Loading,
            is State.Error
            -> newsList.showState(state)
        }
    }
}
