package com.nadia.pertemuan10.repository

import com.nadia.pertemuan10.model.Mahasiswa
import com.nadia.pertemuan10.service_api.MahasiswaService
import okio.IOException

interface MahasiswaRepository {

    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    suspend fun getMahasiswa(): List<Mahasiswa>

    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)

    suspend fun deleteMahasiswa(nim: String)

    suspend fun getMahasiswaNim(nim: String): Mahasiswa
}

class NetworkKontrakRepository(
    private val kontakApiService: MahasiswaService
) : MahasiswaRepository{

    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        kontakApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        kontakApiService.updateMahasiswa(nim, mahasiswa)
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try {
            val response = kontakApiService.deleteMahasiswa(nim)
            if (response.isSuccessful) {
                throw IOException("Failed to delete kontak. HTTp Status code: " +
                        "${response.code()}")
            }else {
                response.message()
                println(response.message())
            }
        } catch (e:Exception){
            throw e
        }
    }

    override suspend fun getMahasiswa(): List<Mahasiswa> =
        kontakApiService.getAllMahasiswa()

    override suspend fun getMahasiswaNim(nim: String): Mahasiswa {
        return kontakApiService.getMahasiswaNim(nim)
    }


}