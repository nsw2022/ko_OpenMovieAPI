package com.example.ko_openmovieapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ko_openmovieapi.databinding.RecyclerItemBinding

class MyAdapter constructor(val context: Context,val items:MutableList<MovieItem>): RecyclerView.Adapter<MyAdapter.VH>(){

    inner class VH (itemView: View) : ViewHolder(itemView) {
        val binding:RecyclerItemBinding = RecyclerItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater:LayoutInflater= LayoutInflater.from(context)
        var itemView:View = layoutInflater.inflate(R.layout.recycler_item,parent,false)
        return VH(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.tvName.text = items[position].movieNm
        holder.binding.tvRank.text = items[position].rank
        holder.binding.tvAudi.text = items[position].audiCnt
        holder.binding.tvOpen.text = items[position].openDt
    }
}
