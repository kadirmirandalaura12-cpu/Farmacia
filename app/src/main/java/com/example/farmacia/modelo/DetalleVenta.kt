package com.example.farmacia.modelo

class DetalleVenta(
    private val producto: Producto,
    private val cantidad: Int
) {
    fun subtotal(): Double {
        return producto.obtenerPrecio() * cantidad
    }
}