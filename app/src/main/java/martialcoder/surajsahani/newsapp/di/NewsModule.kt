package martialcoder.surajsahani.newsapp.di

import martialcoder.surajsahani.newsapp.api.NewsService
import dagger.Module
import dagger.Provides
import martialcoder.surajsahani.newsapp.utils.create
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit): NewsService = retrofit.create()

}