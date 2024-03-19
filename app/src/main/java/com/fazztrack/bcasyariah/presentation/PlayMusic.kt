package com.fazztrack.bcasyariah.presentation

// tanda {} pada method di interface menandakan bahwa method tersebut tidak wajib dioverride
// semua method di interface wajib untuk dioverride jika tidak ada tanda {} di methodnya
// inheritance tidak bisa extends class lain, tidak bisa menggunakan contructor

interface PlayMusic {
    fun play(){}
    fun stop(){}
}