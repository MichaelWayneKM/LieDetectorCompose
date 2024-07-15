package com.wkds.liedetector.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private var waitJob: Job? = null

    fun waitAndExecute(delayMillis: Long, onComplete: () -> Unit) {
        waitJob = viewModelScope.launch {
            try {
                delay(delayMillis)
                onComplete()
            } catch (e: CancellationException) {
                println("Wait was cancelled.")
            }
        }
    }

    fun cancel() {
        waitJob?.cancel()
        waitJob = null
    }
}
