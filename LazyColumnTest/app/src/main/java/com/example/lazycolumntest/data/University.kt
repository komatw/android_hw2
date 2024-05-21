package com.example.lazycolumntest.data

import java.io.Serializable

data class University(
    val id: Int,
    val title: String,
    val address: String,
    val phoneNum: String,
    val url: String,
    val universityImageId: Int = 0,
    val universityLatLng_X: Double,
    val universityLatLng_Y: Double


):Serializable