package martialcoder.surajsahani.newsapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.martialcoder.newsapp.di.base.ViewModelFactory
import com.martialcoder.newsapp.di.base.ViewModelKey
import martialcoder.surajsahani.newsapp.ui.newslist.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    internal abstract fun bindNewsViewModel(newsViewModel: NewsViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
