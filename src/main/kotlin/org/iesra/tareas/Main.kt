package org.iesra.tareas

import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("MainLogger")

fun main() {

    val lista = ListaTareas()
    var opcion: Int

    do {
        logger.info("\n--- MENÚ DE TAREAS ---")
        logger.info("1. Agregar tarea")
        logger.info("2. Eliminar tarea")
        logger.info("3. Marcar tarea como realizada")
        logger.info("4. Mostrar todas las tareas")
        logger.info("5. Mostrar tareas pendientes")
        logger.info("6. Mostrar tareas realizadas")
        logger.info("0. Salir")
        logger.info("Elige una opción: ")

        opcion = readLine()?.toIntOrNull() ?: -1

        when (opcion) {
            1 -> {
                logger.info("Descripción de la tarea: ")
                val descripcion = readLine().orEmpty()
                lista.agregarTarea(descripcion)
                logger.info("Tarea añadida")
            }
            2 -> {
                logger.info("ID de la tarea a eliminar: ")
                val id = readLine()?.toIntOrNull()
                if (id != null && lista.eliminarTarea(id)) {
                    logger.info("Tarea eliminada")
                } else {
                    logger.info("No se encontró la tarea")
                }
            }
            3 -> {
                logger.info("ID de la tarea a marcar como realizada: ")
                val id = readLine()?.toIntOrNull()
                if (id != null && lista.marcarComoRealizada(id)) {
                    logger.info("Tarea marcada como realizada")
                } else {
                    logger.info("No se encontró la tarea")
                }
            }
            4 -> lista.mostrarTodas()
            5 -> lista.mostrarPendientes()
            6 -> lista.mostrarRealizadas()
            0 -> logger.info("Saliendo del programa...")
            else -> logger.info("Opción no válida")
        }

    } while (opcion != 0)
}