package com.omoolen.omooroid.home.fragments.one.curating

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omoolen.omooroid.databinding.ItemOneCuratingBinding
import com.omoolen.omooroid.home.fragments.one.LensColorListAdapter

class CuratingListAdapter:RecyclerView.Adapter<CuratingListAdapter.CuratingViewHolder>() {

    private var curateList = emptyList<CuratingInfo>()

    class CuratingViewHolder(
        private val binding : ItemOneCuratingBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(curatingInfo: CuratingInfo){
            binding.curatingInfo = curatingInfo

            val listForColor = LensColorListAdapter()
            listForColor.setColoring(curatingInfo.colors)
            binding.rvOneCuratingColor.adapter = listForColor

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuratingViewHolder {
        val binding = ItemOneCuratingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CuratingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CuratingViewHolder, position: Int) {
        holder.bind(curateList[position])
    }

    override fun getItemCount(): Int = curateList.size

    fun setCurating(curateList : List<CuratingInfo>){
        this.curateList = curateList
        notifyDataSetChanged()
    }

}