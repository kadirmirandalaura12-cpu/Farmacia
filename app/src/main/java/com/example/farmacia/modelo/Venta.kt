package com.example.farmacia.modelo

class Venta(
    private val id: Int,
    private val cliente: Cliente
) {
    private val detalles: MutableList<DetalleVenta> = mutableListOf()

    fun agregarDetalle(detalle: DetalleVenta) {
        detalles.add(detalle)
    }

    fun total(): Double {
        var suma = 0.0
        for (detalle in detalles) {
            suma += detalle.subtotal()
        }
        return suma
    }
}