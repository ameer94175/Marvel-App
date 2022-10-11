package com.example.marvelapp.util

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.add(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun <T> MutableLiveData<Event<T>>.postEvent(content: T) {
    postValue(Event(content))
}