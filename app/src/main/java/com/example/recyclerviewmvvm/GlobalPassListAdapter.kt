package com.example.recyclerviewmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerviewmvvm.POJO.GobalPassListingPOJO

class GlobalPassListAdapter(private val globalPassList:List<GobalPassListingPOJO>): RecyclerView.Adapter<GlobalPassListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val GobalPassListingPOJO=globalPassList[position]
        holder.mTxtName.text=GobalPassListingPOJO[position].NAME
    }

    override fun getItemCount(): Int {
        return globalPassList.size
    }

    class ItemViewHolder(ItemView: View):ViewHolder(ItemView) {
        val mTxtName: TextView =ItemView.findViewById(R.id.textView)
    }
}