package org.iesra.tareas

import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("MainLogger")

class ListaTareas {

    private val tareas = mutableListOf<Tarea>()
    private var contadorId = 1

    fun agregarTarea(descripcion: String) {
        val tarea = Tarea(contadorId, descripcion)
        tareas.add(tarea)
        contadorId++
    }

    fun eliminarTarea(id: Int): Boolean {
        return tareas.removeIf { it.id == id }
    }

    fun marcarComoRealizada(id: Int): Boolean {
        val tarea = tareas.find { it.id == id }
        return if (tarea != null) {
            tarea.marcarComoRealizada()
            true
        } else {
            false
        }
    }

    fun mostrarTodas() {
        if (tareas.isEmpty()) {
            logger.info("No hay tareas")
        } else {
            tareas.forEach { println(it) }
        }
    }

    fun mostrarPendientes() {
        val pendientes = tareas.filter { !it.realizada }
        if (pendientes.isEmpty()) {
            logger.info("No hay tareas pendientes")
        } else {
            pendientes.forEach { println(it) }
        }
    }

    fun mostrarRealizadas() {
        val realizadas = tareas.filter { it.realizada }
        if (realizadas.isEmpty()) {
            logger.info("No hay tareas realizadas")
        } else {
            realizadas.forEach { println(it) }
        }
    }
}