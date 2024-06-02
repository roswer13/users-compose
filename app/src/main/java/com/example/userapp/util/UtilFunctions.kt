package com.example.userapp.util

import android.util.Log
import java.text.NumberFormat
import java.util.Locale

object UtilFunctions {
    private val localeID = Locale("es", "ES")

    fun logE(message: String) {
        Log.e("ERROR_IMO", message)
    }

    fun Long?.fromDollarToRupiah(): String {
        val localId = localeID
        val formatter = NumberFormat.getCurrencyInstance(localId)
        val fakeDollarToday = 15000
        val intValue = (this ?: 0) * fakeDollarToday
        return when {
            intValue > 0 -> formatter.format(intValue).replace(",00", "")
            intValue < 0 -> formatter.format(intValue).replace(",00", "")
            else -> "Rp0"
        }
    }
}