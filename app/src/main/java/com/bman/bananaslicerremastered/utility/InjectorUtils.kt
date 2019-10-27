package com.bman.bananaslicerremastered.utility

import com.bman.bananaslicerremastered.data.FakeDatabase
import com.bman.bananaslicerremastered.data.QuoteRepository
import com.bman.bananaslicerremastered.ui.BananaViewModelFactory

// Finally a singleton which doesn't need anything passed to the constructor
object InjectorUtils {

    // This will be called from QuotesActivity
    fun provideBananaViewModelFactory(): BananaViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return BananaViewModelFactory(quoteRepository)
    }
}