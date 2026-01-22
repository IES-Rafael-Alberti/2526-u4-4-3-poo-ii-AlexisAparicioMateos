package org.iesra.banco

import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("MainLogger")

fun main() {

    val persona = Persona("12345678A")

    val cuenta1 = Cuenta(1)
    val cuenta2 = Cuenta(2, 700.0)

    persona.agregarCuenta(cuenta1)
    persona.agregarCuenta(cuenta2)

    cuenta1.abonar(1100.0)

    cuenta2.pagar(750.0)

    logger.info("¿Es morosa? ${Cuenta.esMorosa(persona)}")

    Cuenta.transferencia(
        persona,
        persona,
        1,
        2,
        200.0
    )

    logger.info("\nEstado final:")
    persona.mostrarEstado()
    logger.info("¿Es morosa? ${Cuenta.esMorosa(persona)}")
}