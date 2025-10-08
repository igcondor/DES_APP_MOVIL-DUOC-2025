package com.example.proyectobase.API

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Objeto que conecta la aplicacion con el webservices
 * usa corrutinas para que las llamadas se ejecuten en segundo plano asi
 * no bloquea el hilo principal
 */

//ESTE ARCHIVO SOLO INSTANCIA PARA QUE SE EJECUTEN EN SEGUNDO PLANO
object AlumnosRepository {

    suspend fun fetchAlumnos(): Result<List<Alumno>> = withContext(Dispatchers.IO) {
        try {
            Result.success(ApiDuocClient.service.getAlumnos())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun insertAlumno(request: AlumnoInsertRequest): Result<InsertResponse> = withContext(Dispatchers.IO) {
        try {
            Result.success(ApiDuocClient.service.insertAlumno(request))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
