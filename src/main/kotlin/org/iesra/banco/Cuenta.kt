package org.iesra.banco

class Cuenta(
    val numeroCuenta: Int,
    private var saldo: Double = 0.0
) {

    fun consultarSaldo(): Double {
        return saldo
    }

    fun abonar(cantidad: Double) {
        if (cantidad > 0) {
            saldo += cantidad
        }
    }

    fun pagar(cantidad: Double): Boolean {
        return if (cantidad > 0) {
            saldo -= cantidad
            true
        } else {
            false
        }
    }

    companion object {

        fun esMorosa(persona: Persona): Boolean {
            for (cuenta in persona.cuentas) {
                if (cuenta != null && cuenta.consultarSaldo() < 0) {
                    return true
                }
            }
            return false
        }

        fun transferencia(
            personaOrigen: Persona,
            personaDestino: Persona,
            numCuentaOrigen: Int,
            numCuentaDestino: Int,
            cantidad: Double
        ): Boolean {

            if (cantidad <= 0) return false

            val cuentaOrigen = personaOrigen.buscarCuenta(numCuentaOrigen)
            val cuentaDestino = personaDestino.buscarCuenta(numCuentaDestino)

            if (cuentaOrigen == null || cuentaDestino == null) return false

            cuentaOrigen.pagar(cantidad)
            cuentaDestino.abonar(cantidad)
            return true
        }
    }
}