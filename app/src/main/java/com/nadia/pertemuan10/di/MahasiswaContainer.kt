package com.nadia.pertemuan10.di

import com.nadia.pertemuan10.repository.MahasiswaRepository

interface AppContainer{
    val kontakRepository: MahasiswaRepository
}