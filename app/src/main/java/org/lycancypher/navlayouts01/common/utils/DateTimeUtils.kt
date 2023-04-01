package org.lycancypher.navlayouts01.common.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {
    fun getDate(): Long {
        val date = Date()
        val year: Int
        val month: Int
        val day: Int
        val calendar: Calendar = Calendar.getInstance(Locale.getDefault())

        calendar.time = date
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)

        calendar.set(year - 18, month, day)
        return calendar.timeInMillis
    }

    @SuppressLint("SimpleDateFormat")
    fun parseDate(date: Long?): String? {
        val dateParse = SimpleDateFormat("dd-MM-yyyy")

        return dateParse.format(date)
    }
}