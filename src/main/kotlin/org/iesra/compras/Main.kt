package org.iesra.compras

import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("MainLogger")

fun main() {

    val repo = RepositorioCompras()

    val c1 = Cliente("Alexis Aparicio", Domicilio("Calle Rafael Alberti", 355))
    val c2 = Cliente("Antonio Martinez", Domicilio("Avenida Cadiz", 218))
    val c3 = Cliente("Julián Rodriguez", Domicilio("Jerez", 761))

    repo.agregarCompra(Compra(c1, 5, 12780.78))
    repo.agregarCompra(Compra(c2, 7, 699.0))
    repo.agregarCompra(Compra(c1, 7, 532.90))
    repo.agregarCompra(Compra(c3, 12, 5715.99))
    repo.agregarCompra(Compra(c2, 15, 958.0))

    repo.domicilios().forEach {
        logger.info(it.dirCompleta())
    }
}