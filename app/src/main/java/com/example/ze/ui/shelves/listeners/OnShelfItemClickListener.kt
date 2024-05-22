package com.example.ze.ui.shelves.listeners

import com.example.ze.roomdb.entities.LocalShelf

interface OnShelfItemClickListener {
    fun onClick(localShelf: LocalShelf)
}