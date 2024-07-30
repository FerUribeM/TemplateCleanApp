package com.ferbajoo.templetecleanapp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import java.text.SimpleDateFormat
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

fun Context.openLink(url: String?) {
    if (url == null) return
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}