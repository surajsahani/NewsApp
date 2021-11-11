package martialcoder.surajsahani.newsapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import martialcoder.surajsahani.newsapp.ui.newslist.NewsActivity


@Module
abstract class ActivityModule {

    // News
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): NewsActivity

}
