package com.example.ze.ui.search.listeners

import android.widget.ImageButton
import com.example.ze.model.googlebooksmodel.DataModel
import com.google.android.material.progressindicator.CircularProgressIndicator

interface OnBookAddButtonClickListener {
    fun onAddButtonClick(
        localBook: DataModel.LocalBook,
        addButton: ImageButton,
        addedButton: ImageButton,
        progressBar: CircularProgressIndicator
    )

    fun onAddedButtonClick(
        id: String,
        addButton: ImageButton,
        addedButton: ImageButton,
        progressBar: CircularProgressIndicator
    )
}