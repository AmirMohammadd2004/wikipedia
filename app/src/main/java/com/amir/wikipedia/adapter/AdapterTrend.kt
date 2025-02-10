package com.amir.wikipedia.dataclass

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amir.wikipedia.databinding.CardviewTrendBinding
import com.bumptech.glide.Glide
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class AdapterTrend(val data: ArrayList<DataClassTrend>, val itemEventTrend: Item_Event_Trend) : RecyclerView.Adapter<AdapterTrend.AdapterViewHolder>() {

    lateinit var binding: CardviewTrendBinding


    inner class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        @SuppressLint("CheckResult", "SetTextI18n")
        fun Bindview(dataClassTrend: DataClassTrend) {

            Glide.with(itemView)
                .load(dataClassTrend.imgurl)
                .transform(RoundedCornersTransformation(15,10))
                .into(binding.imgMain)

            binding.textTrend.text = dataClassTrend.text_trend
            binding.textTextsubject.text = dataClassTrend.text_textsubject
            binding.textSubject.text = dataClassTrend.textsubject
            binding.numberCard.text = (adapterPosition+1).toString()

            itemView.setOnClickListener {

                itemEventTrend.item_click_trend(dataClassTrend)

            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        binding =
            CardviewTrendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {

        holder.Bindview(data[position])


    }
}

interface Item_Event_Trend {

    fun item_click_trend(dataClassTrend: DataClassTrend)
}