package com.alexandreobsilva.a12passosnamauricio.view.fragments.list.expansible

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExpansibleItem(
    val title: CharSequence,
    val description: CharSequence
) : Parcelable
