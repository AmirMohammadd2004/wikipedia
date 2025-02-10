package com.amir.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amir.wikipedia.databinding.CardviewExplorBinding
import com.amir.wikipedia.dataclass.DataClassExplore
import com.bumptech.glide.Glide

class AdapterExplore(val data: ArrayList<DataClassExplore>, val itemEvent: Item_Event) :
    RecyclerView.Adapter<AdapterExplore.AdapterViewHolder>() {

    lateinit var binding: CardviewExplorBinding

    inner class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun BindViews(dataClassExplore: DataClassExplore) {
            Glide.with(itemView.context)
                .load(dataClassExplore.url_img)
                .into(binding.ImageExploreMain)
            binding.textExplorTitle.text = dataClassExplore.text_title
            binding.textExploreDetail.text = dataClassExplore.text_detail
            binding.textExplorSubtitle.text = dataClassExplore.text_subtitle


            itemView.setOnClickListener {

                itemEvent.item_click(dataClassExplore)

            }




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        binding = CardviewExplorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.BindViews(data[position])

    }
}


interface Item_Event {

    fun item_click(dataClassExplore: DataClassExplore)

}