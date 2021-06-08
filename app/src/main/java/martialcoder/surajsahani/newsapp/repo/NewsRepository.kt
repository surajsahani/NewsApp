package martialcoder.surajsahani.newsapp.repo

import martialcoder.surajsahani.newsapp.api.NewsService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val newsService: NewsService
) {
    fun getTopHeadlines(category: String) = newsService.getTopHeadlines(category)
}