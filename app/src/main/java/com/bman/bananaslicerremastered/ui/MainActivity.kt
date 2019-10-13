package com.bman.bananaslicerremastered.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bman.bananaslicerremastered.R
import com.bman.bananaslicerremastered.data.Quote
import com.bman.bananaslicerremastered.utility.InjectorUtils
import kotlinx.android.synthetic.main.main_activity.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()

        // ViewModelProviders.of is deprecated
        // https://stackoverflow.com/questions/53903762/viewmodelproviders-is-deprecated-in-1-1-0
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach {quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }

    }
}
