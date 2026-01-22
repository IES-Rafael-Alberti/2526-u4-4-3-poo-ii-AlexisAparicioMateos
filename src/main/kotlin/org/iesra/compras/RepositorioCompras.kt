package org.iesra.compras

class RepositorioCompras {

    private val compras = mutableListOf<Compra>()

    fun agregarCompra(compra: Compra) {
        compras.add(compra)
    }

    fun domicilios(): Set<Domicilio> {
        return compras
            .map { it.cliente.domicilio }
            .toSet()
    }
}