package com.bman.bananaslicerremastered.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bman.bananaslicerremastered.data.QuoteRepository

// The same repository that's needed for BananaViewModel
// is also passed to the factory
class BananaViewModelFactory(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BananaViewModel(quoteRepository) as T
    }

}