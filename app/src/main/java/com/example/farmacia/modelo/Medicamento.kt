package com.example.farmacia.modelo

class Medicamento(
    codigo: String,
    nombre: String,
    precio: Double,
    stock: Int,
    private val laboratorio: String,
    private val requiereReceta: Boolean
) : Producto(codigo, nombre, precio, stock) {

    override fun descripcion(): String {
        val receta = if (requiereReceta) "Sí" else "No"
        return "$nombre ($codigo)\nLaboratorio: $laboratorio\nPrecio: Bs $precio\nStock: $stock\nRequiere receta: $receta"
    }
}