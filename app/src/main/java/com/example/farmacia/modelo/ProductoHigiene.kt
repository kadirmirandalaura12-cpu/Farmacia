package com.example.farmacia.modelo

class ProductoHigiene(
    codigo: String,
    nombre: String,
    precio: Double,
    stock: Int,
    private val marca: String
) : Producto(codigo, nombre, precio, stock) {

    override fun descripcion(): String {
        return "$nombre ($codigo)\nMarca: $marca\nPrecio: Bs $precio\nStock: $stock"
    }
}