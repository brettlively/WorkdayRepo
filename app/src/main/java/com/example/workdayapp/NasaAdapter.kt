package com.example.workdayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.workdayapp.viewmodel.NasaImageInfo

class NasaAdapter() : RecyclerView.Adapter<NasaAdapter.CellViewHolder>() {

    private var nasaList: List<NasaImageInfo> = emptyList()

    inner class CellViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val imageIV: ImageView? = itemView.findViewById(R.id.cell_image)
        val titleTV: TextView? = itemView.findViewById(R.id.cell_title)
    }

    fun setAdapterData(nasaImageInfo: List<NasaImageInfo>){
        nasaList = nasaImageInfo
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_item, parent, false)
        return  CellViewHolder(view)
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        val item = nasaList.get(position)
        Glide.with(holder.itemView).load(item.imageUrl).into(holder.imageIV!!)
        holder.titleTV?.text = nasaList[position].title
    }

    override fun getItemCount(): Int {
        return nasaList.size
    }
}
