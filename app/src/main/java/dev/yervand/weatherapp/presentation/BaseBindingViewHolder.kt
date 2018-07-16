package dev.yervand.weatherapp.presentation

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

class BaseBindingViewHolder(binding: ViewDataBinding, private val clickListener: ClickListener) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    interface ClickListener {
        fun onViewClick(position: Int, view: View)
    }

    init {
        binding.root.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        clickListener.onViewClick(adapterPosition, v)
    }
}