package com.wkds.liedetector.utils

import kotlinx.coroutines.*

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
    }
}