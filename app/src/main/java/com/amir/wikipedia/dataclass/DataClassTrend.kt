package com.amir.wikipedia.dataclass
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class DataClassTrend (
    val imgurl:String,
    val textsubject:String,
    val text_textsubject:String,
    val text_main: String,
    val text_trend :String

):Parcelable