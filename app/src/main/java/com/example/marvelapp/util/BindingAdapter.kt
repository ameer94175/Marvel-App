package com.example.marvelapp.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.base.BaseAdapter
import com.example.marvelapp.data.marvelresponse.Thumbnail

@BindingAdapter(value = ["app:showWHenLoading"])
fun <T>showWHenLoading(view: View, state: State<T>?) {
    if (state is State.Loading){
        view.visibility = View.VISIBLE
    }else {
        view.visibility = View.GONE
    }
}


@BindingAdapter(value = ["app:showWhenError"])
fun <T>showWhenError(view: View, state: State<T>?) {
    if (state is State.Error){
        view.visibility = View.VISIBLE
    }else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T>showWhenSuccess(view: View, state: State<T>?) {
    if (state is State.Success) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}
@BindingAdapter(value = ["app:imageUrl"])
fun imageUrl(view:ImageView,url: Thumbnail?){

    url?.let {
        Glide.with(view).load("${url.path}.${url.extension}").centerCrop().into(view)
    }
}

@BindingAdapter(value = ["app:itemMarvel"])
fun <T> itemMarvel(view: RecyclerView, items: List<T>?){
    if (items != null){
        (view.adapter as BaseAdapter<T>?)?.setItems(items)
    }else {
        (view.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}


