package com.example.tvshowmanager.util

import androidx.lifecycle.Observer
import com.example.tvshowmanager.model.ApiResult


open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    /** Returns the content and prevents its use again. */
    fun getContentIfNotHandled(): T? = if (hasBeenHandled) null else {
        hasBeenHandled = true
        content
    }

}

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let(onEventUnhandledContent)
    }
}

sealed class EventType {
    class Error(val error: ApiResult.Error) : EventType()
    object ShowProgress : EventType()
    object HideProgress : EventType()
}

