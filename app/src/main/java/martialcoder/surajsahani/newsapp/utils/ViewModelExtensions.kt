package martialcoder.surajsahani.newsapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import martialcoder.surajsahani.newsapp.di.base.ViewModelFactory
import martialcoder.surajsahani.newsapp.ui.base.BaseActivity

/**
 * Synthetic sugaring to get instance of [ViewModel] from [ViewModelFactory] combined
 * with DI.
 */
inline fun <reified T : ViewModel> BaseActivity.getViewModel(): T {
    return ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
}
