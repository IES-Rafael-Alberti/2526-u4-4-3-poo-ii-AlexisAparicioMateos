package org.iesra.tareas

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Tarea(
    val id: Int,
    val descripcion: String
) {
    var realizada: Boolean = false
        private set

    var fechaRealizacion: String? = null
        private set

    fun marcarComoRealizada() {
        if (!realizada) {
            realizada = true
            val fechaHoraActual = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
            fechaRealizacion = fechaHoraActual.format(formatter)
        }
    }

    override fun toString(): String {
        return if (realizada) {
            "[$id] $descripcion → Realizada el $fechaRealizacion"
        } else {
            "[$id] $descripcion → Pendiente"
        }
    }
}