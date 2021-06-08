package martialcoder.surajsahani.newsapp.api

import io.reactivex.Observable
import martialcoder.surajsahani.newsapp.api.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    /**
     * Get list of top headlines for the `category`
     */
    @GET("top-headlines")
    fun getTopHeadlines(@Query("category") category: String): Observable<NewsResponse>

}
