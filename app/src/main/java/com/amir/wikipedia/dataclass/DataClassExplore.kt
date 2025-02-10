package com.amir.wikipedia.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataClassExplore(
    val url_img: String,
    val text_title: String,
    val text_subtitle: String,
    val text_detail: String
) :Parcelable