package com.bman.bananaslicerremastered.ui

import androidx.lifecycle.ViewModel
import com.bman.bananaslicerremastered.data.Quote
import com.bman.bananaslicerremastered.data.QuoteRepository


// QuoteRepository dependency will again be passed in the
// constructor using dependency injection
class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}