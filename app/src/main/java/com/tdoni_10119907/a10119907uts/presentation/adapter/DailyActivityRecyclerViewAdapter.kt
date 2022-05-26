package com.tdoni_10119907.a10119907uts.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tdoni_10119907.a10119907uts.databinding.ItemDailyActivityBinding
import com.tdoni_10119907.a10119907uts.domain.DailyActivity

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class DailyActivityRecyclerViewAdapter(private val dailyActivities: Array<DailyActivity>) :
    RecyclerView.Adapter<DailyActivityRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDailyActivityBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemDailyActivityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        binding.txtViewHour.text = dailyActivities[position].hour
        binding.txtViewActivityName.text = dailyActivities[position].name
    }

    override fun getItemCount(): Int = 6
}