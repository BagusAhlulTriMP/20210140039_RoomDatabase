package com.example.roomdbtest.ui.theme

import android.app.Application
import com.example.roomdbtest.repositori.ContainerApp
import com.example.roomdbtest.repositori.ContainerDataApp

class AplikasiSiswa : Application() {
    /**
     * AppContainer instance digunakan oleh kelas-kelas lainnya untuk mendapatkan dependensi
     */
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}