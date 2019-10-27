package com.bman.bananaslicerremastered.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bman.bananaslicerremastered.R
import com.bman.bananaslicerremastered.databinding.MainActivityBinding
import com.bman.bananaslicerremastered.utility.InjectorUtils
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    val mBdinding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideBananaViewModelFactory()

        // ViewModelProviders.of is deprecated
        // https://stackoverflow.com/questions/53903762/viewmodelproviders-is-deprecated-in-1-1-0
        val viewModel = ViewModelProvider(this, factory).get(BananaViewModel::class.java)
//        viewModel.getQuotes().observe(this, Observer { quotes ->
//            val stringBuilder = StringBuilder()
//            quotes.forEach {quote ->
//                stringBuilder.append("$quote\n\n")
//            }
//            textView_quotes.text = stringBuilder.toString()
//        })

        button_add_quote.setOnClickListener {
        }

    }
}
