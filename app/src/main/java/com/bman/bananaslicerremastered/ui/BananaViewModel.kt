package com.bman.bananaslicerremastered.ui

import androidx.lifecycle.ViewModel
import com.bman.bananaslicerremastered.data.Quote
import com.bman.bananaslicerremastered.data.QuoteRepository

/**
 * The Model's purpose is to represent (or model) your business domain. Therefore, business logic by definition goes in the Model, not the ViewModel.
The job of the ViewModel is to expose properties and fields of the Model, and prepare them for consumption by the View.
For instance, picture a banking application. The Model may represent an account. Perhaps the Model has an account balance. The job of the Model may be to track the balance and make sure certain invariants are maintained (such as not allowing a withdrawal that is larger than the balance). The job of the ViewModel may be to turn the balance into a string that is used as a binding in the View.
You want to keep as much logic out of the ViewModel as possible to keep your code reusable and loosely coupled.
 */
// QuoteRepository dependency will again be passed in the
// constructor using dependency injection
class BananaViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}