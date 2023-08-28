package com.sina.ontimeeventchannel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    sealed class CustomEvents {
        data class ErrorEvent(val message: String) : CustomEvents()
    }

    private val channel = Channel<CustomEvents>()
    val channelFlow = channel.receiveAsFlow()


    fun triggerEvent() = viewModelScope.launch {
//        /**
//         * consumeEach this block will fire off every time send function called
//         * as u can see its will produce CustomEvents
//         */
//        channel.consumeEach {
//
//        }
        channel.send(CustomEvents.ErrorEvent("Error!"))
    }
}