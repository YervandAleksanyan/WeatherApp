package dev.yervand.weatherapp.weather.forecastlist

import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import dev.yervand.weatherapp.R
import dev.yervand.weatherapp.databinding.ForecastItemBinding
import dev.yervand.weatherapp.domain.WeatherService
import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.presentation.BaseBindingAdapter
import dev.yervand.weatherapp.presentation.BaseBindingViewHolder
import dev.yervand.weatherapp.utils.TimeUtil
import javax.inject.Inject

class ForecastListAdapter @Inject constructor() : BaseBindingAdapter<Forecast>() {

    override fun bind(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewDataBinding = ForecastItemBinding.inflate(inflater, parent, false)

    override fun onBindViewHolder(holder: BaseBindingViewHolder, position: Int) {
        val item: Forecast = getItems()[position]
        val binding = holder.binding as ForecastItemBinding
        binding.day.text = TimeUtil.convertDayAndTime(item.dt * 1000)
        binding.minDegree.text = "${item.main.tempMin}\u00B0"
        binding.maxDegree.text = "${item.main.tempMax}\u00B0"
        Picasso
                .get()
                .load("${WeatherService.ICON_ENDPOINT}${item.weather[0].icon}.png")
                .error(R.drawable.ic_rain)
                .into(binding.weatherIcon)
        if (item.selected)
            binding.contentLayout.setBackgroundResource(R.drawable.selected_card_backgorund)
        else
            binding.contentLayout.setBackgroundColor(R.drawable.selected_card_backgorund)
    }
}