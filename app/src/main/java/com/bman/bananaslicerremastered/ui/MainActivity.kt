package com.bman.bananaslicerremastered.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bman.bananaslicerremastered.R
import com.bman.bananaslicerremastered.databinding.MainActivityBinding
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initializeUi()
    }

    private fun initializeUi() {
        val viewModel = ViewModelProvider(this, BananaViewModelFactory()).get(BananaViewModel::class.java)

        mBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        mBinding.lifecycleOwner = this

        mBinding.viewModel = viewModel

        btnIncreaseBananas.setOnClickListener {
            viewModel.increaseBananas(500)
        }

        decrease_bananas.setOnClickListener {
            viewModel.decreaseBananas()
        }

    }
}
