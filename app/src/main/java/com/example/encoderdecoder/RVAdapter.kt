package com.example.encoderdecoder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter (var list: List<String>):RecyclerView.Adapter<RVAdapter.RVholder>(){
    class RVholder(itemview:View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.RVholder {
       return RVholder(LayoutInflater.from(parent.context).inflate(
           R.layout.item_row,
           parent,
           false
       ))

    }

    override fun onBindViewHolder(holder: RVAdapter.RVholder, position: Int) {

        holder.itemView.apply {
            textView.text=list[position]
        }
    }

    override fun getItemCount()=list.size
}