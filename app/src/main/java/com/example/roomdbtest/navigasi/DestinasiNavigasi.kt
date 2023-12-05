package com.example.roomdbtest.navigasi

interface DestinasiNavigasi {
    /**
     * Nama unik untuk menentukan jaluk untuk composable
     */
    val route: String

    /**
     * String resource id yang berisi judul yang akan ditampilkan dilayar halaman.
     */
    val titleRes: Int
}