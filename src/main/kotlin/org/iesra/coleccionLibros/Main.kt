package org.iesra.coleccionLibros

fun main() {

    val conjunto = ConjuntoLibros(4)

    val libro1 = Libro(
        "Dragon Ball",
        "Akira Toriyama",
        192,
        9
    )

    val libro2 = Libro(
        "Naruto",
        "Masashi Kishimoto",
        220,
        8
    )

    conjunto.anadirLibro(libro1)
    conjunto.anadirLibro(libro2)

    conjunto.mostrarMayorCalificacion()
    conjunto.mostrarMenorCalificacion()

    conjunto.eliminarPorTitulo("Dragon Ball")

    conjunto.eliminarPorAutor("Masashi Kishimoto")

    conjunto.mostrarConjunto()

    val libro3 = Libro(
        "One Piece",
        "Eiichiro Oda",
        210,
        10
    )

    conjunto.anadirLibro(libro3)

    conjunto.mostrarConjunto()
}