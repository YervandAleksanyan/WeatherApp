package dev.yervand.weatherapp.utils

import android.databinding.BindingAdapter
import android.widget.*
import com.squareup.picasso.Picasso
import dev.yervand.weatherapp.R
import dev.yervand.weatherapp.domain.WeatherService
import java.text.SimpleDateFormat
import java.util.*


object BindingAdapters {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(path: String?) {
        Picasso
                .get()
                .load("${WeatherService.ICON_ENDPOINT}${path}.png")
                .into(this)
    }

    @JvmStatic
    @BindingAdapter("cityBackground")
    fun ImageView.setBackground(drawableID: Int) {
        this.setBackgroundResource(drawableID)
    }

    @JvmStatic
    @BindingAdapter("spinnerItems")
    fun Spinner.setItems(items: ArrayList<String>) {
        this.adapter = ArrayAdapter<String>(this.context, R.layout.support_simple_spinner_dropdown_item, items)
    }

    @JvmStatic
    @BindingAdapter("select")
    fun LinearLayout.setSelectableBackground(selected: Boolean) {
        if (selected)
            this.setBackgroundResource(R.drawable.selected_card_backgorund)
        else
            this.setBackgroundColor(R.drawable.selected_card_backgorund)
    }

    @JvmStatic
    @BindingAdapter("dayAndTime")
    fun TextView.changeText(timeStamp: Long) {
        val sdf = SimpleDateFormat("EEE, MMM d,HH:mm")
        val netDate = Date(timeStamp * 1000)
        this.text = sdf.format(netDate)
    }
}