package com.example.marvelapp.adapter



import com.example.marvelapp.base.BaseAdapter
import com.example.marvelapp.base.BaseInteractionListener
import com.example.marvelapp.data.marvelresponse.Result
import com.example.marvelapp.R


class MarvelAdapter(item:List<Result>, listener: MarvelInteractionListener): BaseAdapter<Result>(item,listener) {
    override val layoutId: Int = R.layout.item_marvel
}

interface MarvelInteractionListener : BaseInteractionListener {
    fun onClickMarver(marvel: Result)
}




// class MarvelAdapter(private var items:List<Result>?, private val listener2: MarvelInteractionListener2)
//    : RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder>(){
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
//        return MarvelViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_marvel,parent
//            ,false))
//    }
//
//    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
//        val currntItem = items?.get(position)
//        holder.binding.apply {
//            item = currntItem
//            listener = listener2
//        }
//    }
//
//    fun setItems(newItems:List<Result>?){
//        items = newItems
//        notifyDataSetChanged()
//    }
//
//
//    override fun getItemCount() = items?.size!!
//
//
//class MarvelViewHolder(itemVie: View):RecyclerView.ViewHolder(itemVie){
//    val binding = ItemMarvelBinding.bind(itemVie)
//}
//}
//
//interface MarvelInteractionListener2 {
//    fun onClickMarver(marvel: Result)
//}




