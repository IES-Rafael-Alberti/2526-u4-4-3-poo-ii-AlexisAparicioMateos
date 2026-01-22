package org.iesra.coleccionLibros

import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("MainLogger")

class ConjuntoLibros(tamano: Int) {

    private val libros: Array<Libro?> = arrayOfNulls(tamano)

    fun anadirLibro(libro: Libro): Boolean {
        for (l in libros) {
            if (l != null && l.titulo == libro.titulo) {
                return false
            }
        }

        for (i in libros.indices) {
            if (libros[i] == null) {
                libros[i] = libro
                return true
            }
        }
        return false
    }

    fun eliminarPorTitulo(titulo: String): Boolean {
        for (i in libros.indices) {
            val libro = libros[i]
            if (libro != null && libro.titulo == titulo) {
                libros[i] = null
                return true
            }
        }
        return false
    }

    fun eliminarPorAutor(autor: String): Boolean {
        var eliminado = false
        for (i in libros.indices) {
            val libro = libros[i]
            if (libro != null && libro.autor == autor) {
                libros[i] = null
                eliminado = true
            }
        }
        return eliminado
    }

    fun mostrarMayorCalificacion() {
        var mejor: Libro? = null

        for (libro in libros) {
            if (libro != null) {
                if (mejor == null || libro.calificacion > mejor.calificacion) {
                    mejor = libro
                }
            }
        }

        if (mejor != null) {
            logger.info("Libro con mayor calificación: ${mejor.titulo} (${mejor.calificacion})")
        } else {
            logger.info("No hay libros")
        }
    }

    fun mostrarMenorCalificacion() {
        var peor: Libro? = null

        for (libro in libros) {
            if (libro != null) {
                if (peor == null || libro.calificacion < peor.calificacion) {
                    peor = libro
                }
            }
        }

        if (peor != null) {
            logger.info("Libro con menor calificación: ${peor.titulo} (${peor.calificacion})")
        } else {
            logger.info("No hay libros")
        }
    }

    fun mostrarConjunto() {
        logger.info("Contenido del conjunto:")
        var vacio = true
        for (libro in libros) {
            if (libro != null) {
                logger.info(
                    "${libro.titulo} - ${libro.autor} | " +
                            "${libro.numPaginas} páginas | Nota ${libro.calificacion}"
                )
                vacio = false
            }
        }
        if (vacio) {
            logger.info("El conjunto está vacío")
        }
    }
}