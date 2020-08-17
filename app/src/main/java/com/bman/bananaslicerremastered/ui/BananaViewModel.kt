package com.bman.bananaslicerremastered.ui

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.fixedRateTimer

/**
 * The Model's purpose is to represent (or model) your business domain. Therefore, business logic by definition goes in the Model, not the ViewModel.
The job of the ViewModel is to expose properties and fields of the Model, and prepare them for consumption by the View.
For instance, picture a banking application. The Model may represent an account. Perhaps the Model has an account balance. The job of the Model may be to track the balance and make sure certain invariants are maintained (such as not allowing a withdrawal that is larger than the balance). The job of the ViewModel may be to turn the balance into a string that is used as a binding in the View.
You want to keep as much logic out of the ViewModel as possible to keep your code reusable and loosely coupled.
 */
// QuoteRepository dependency will again be passed in the
// constructor using dependency injection
class BananaViewModel()
    : ViewModel() {

    private val _bananas =  MutableLiveData<Long>(0)
    val bananas: LiveData<Long>
        get() = _bananas

    private val fixedRateTimer = fixedRateTimer(name = "", initialDelay =  0, period = 200) {
        Handler(Looper.getMainLooper()).post{
            increaseBananas(1)
        }
    }

    fun increaseBananas(delta: Int) {
        _bananas.value = (_bananas.value)?.plus(delta)
    }

    fun decreaseBananas() {
        _bananas.value = (_bananas.value)?.minus(1)
    }

    override fun onCleared() {
        fixedRateTimer.cancel()
        fixedRateTimer.purge()
    }
}