package com.example.ze.model.googlebooksmodel

import com.example.ze.model.googlebooksmodel.DataModel

data class GoogleApiBooks(
    val items: List<DataModel.GoogleBookItem>?,
    val kind: String,
    val totalItems: Int
)