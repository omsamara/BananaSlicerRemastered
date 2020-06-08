package com.bman.bananaslicerremastered.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// The same repository that's needed for BananaViewModel
// is also passed to the factory
class BananaViewModelFactory()
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BananaViewModel() as T
    }

}