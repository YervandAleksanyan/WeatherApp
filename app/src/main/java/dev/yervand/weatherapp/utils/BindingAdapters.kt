package dev.yervand.weatherapp.utils

import android.databinding.BindingAdapter
import android.view.View
import android.widget.*
import com.squareup.picasso.Picasso
import dev.yervand.weatherapp.R
import dev.yervand.weatherapp.domain.WeatherService
import dev.yervand.weatherapp.viewmodels.base.Command
import java.text.SimpleDateFormat
import java.util.*


object BindingAdapters {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadWeatherIcon(path: String?) {
        Picasso
                .get()
                .load("${WeatherService.ICON_ENDPOINT}$path.png")
                .into(this)
    }

    @JvmStatic
    @BindingAdapter("items", "currentPos")
    fun ImageView.setBackground(items: Map<Int, String>, pos: Int) {
        this.setBackgroundResource(items.keys.toList()[pos])
    }

    @JvmStatic
    @BindingAdapter("spinnerItems")
    fun Spinner.setItems(items: Map<Int, String>) {
        this.adapter = ArrayAdapter<String>(this.context, R.layout.support_simple_spinner_dropdown_item, items.values.toMutableList())
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

    @JvmStatic
    @BindingAdapter("spinnerCommand")
    fun Spinner.command(command: Command) {
        this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                command.execute(p3)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("selectedPosition")
    fun Spinner.setSelectedPosition(pos: Int) {
        this.setSelection(pos)
    }


    @JvmStatic
    @BindingAdapter(value = ["isVisible"])
    fun bindViewVisibility(view: View, isVisible: Any) {
        val visible = getVisibility(isVisible)
        view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }

    private fun getVisibility(visibility: Any?): Boolean {
        var isVisible = true
        when (visibility) {
            null -> isVisible = false
            is Boolean -> isVisible = (visibility as Boolean?)!!
            is String -> isVisible = !visibility.isEmpty()
        }
        return isVisible
    }
}