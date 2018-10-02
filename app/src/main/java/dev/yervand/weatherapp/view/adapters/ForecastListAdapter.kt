package dev.yervand.weatherapp.view.adapters

import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.yervand.weatherapp.databinding.ForecastItemBinding
import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.presentation.BaseBindingAdapter
import dev.yervand.weatherapp.presentation.BaseBindingViewHolder
import javax.inject.Inject

class ForecastListAdapter @Inject constructor() : BaseBindingAdapter<Forecast>() {

    override fun bind(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewDataBinding = ForecastItemBinding.inflate(inflater, parent, false)

    override fun onBindViewHolder(holder: BaseBindingViewHolder, position: Int) {
        val binding = holder.binding as ForecastItemBinding
        binding.forecast = getItems()[position]
    }
}