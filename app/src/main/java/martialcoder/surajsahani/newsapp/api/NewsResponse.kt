package martialcoder.surajsahani.newsapp.api

import martialcoder.surajsahani.newsapp.domain.Article

/**
 * JSON response for news
 */
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)