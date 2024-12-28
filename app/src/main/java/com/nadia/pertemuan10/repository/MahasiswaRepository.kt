package com.nadia.pertemuan10.repository

import com.nadia.pertemuan10.model.Mahasiswa

interface MahasiswaRepository {

    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    suspend fun getMahasiswa(): List<Mahasiswa>

    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)

    suspend fun deleteMahasiswa(nim: String)

    suspend fun getMahasiswaNim(nim: String): Mahasiswa
}