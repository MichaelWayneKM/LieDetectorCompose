package com.wkds.liedetector.utils

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CancellableTimer {
    private var waitJob: Job? = null

    fun waitAndExecute(delayMillis: Long, onComplete: () -> Unit) {
        waitJob = CoroutineScope(Dispatchers.Default).launch {
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