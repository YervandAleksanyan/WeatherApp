package dev.yervand.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {
    fun convertDayAndTime(timeStamp: Long): String {
        val sdf = SimpleDateFormat("EEE, MMM d,HH:mm")
        val netDate = Date(timeStamp)
        return sdf.format(netDate)
    }
}
