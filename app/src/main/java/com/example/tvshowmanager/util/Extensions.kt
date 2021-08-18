package com.example.tvshowmanager.util

import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView


fun TextView.makeTextColored(fullString: String, startIndex: Int, endIndex: Int, colorId: Int) {

    val string = SpannableString(fullString)
    string.setSpan(ForegroundColorSpan(colorId), startIndex, endIndex, 0)
    text = string
}


fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}
