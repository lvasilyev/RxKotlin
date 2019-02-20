package com.jonbott.learningrxjava.Activities.NetworkExample

import com.jakewharton.rxrelay2.BehaviorRelay
import com.jonbott.learningrxjava.ModelLayer.Entities.Message
import com.jonbott.learningrxjava.ModelLayer.ModelLayer
import io.reactivex.disposables.CompositeDisposable

class NetworkExamplePresenter {
    val messages: BehaviorRelay<List<Message>>
        get() = modelLayer.messages

    private var bag = CompositeDisposable()
    private val modelLayer = ModelLayer.shared //normally injected

    init {
        modelLayer.getMessages()
    }

}