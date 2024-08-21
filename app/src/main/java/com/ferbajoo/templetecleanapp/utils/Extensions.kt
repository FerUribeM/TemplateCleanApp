package com.ferbajoo.templetecleanapp.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

fun String?.toFormatDate(): String? {
    if (this.isNullOrEmpty()) return null
    val inputDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val outputDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    return try {
        val date = inputDateFormat.parse(this)
        date?.let { outputDateFormat.format(it) }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

fun getYesterdayDate(): String {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, -1)
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return format.format(calendar.time)
}

fun Context.getDeviceLanguage(): String {
    val locale = this.resources.configuration.locales[0]
    return locale.language
}

fun Context.openLink(url: String?) {
    if (url == null) return
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}