package com.example.farmacia.modelo

class Farmacia(
    private val nombre: String
) {
    private val productos: MutableList<Producto> = mutableListOf()
    private val clientes: MutableList<Cliente> = mutableListOf()

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

    fun agregarCliente(cliente: Cliente) {
        clientes.add(cliente)
    }
}