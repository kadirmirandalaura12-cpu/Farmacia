package com.example.farmacia.modelo

abstract class Producto(
    protected val codigo: String,
    protected val nombre: String,
    protected val precio: Double,
    protected val stock: Int
) {
    fun obtenerPrecio(): Double {
        return precio
    }

    fun hayStock(): Boolean {
        return stock > 0
    }

    abstract fun descripcion(): String
}