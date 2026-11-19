package com.example.farmacia.modelo

class Cliente(
    private val ci: String,
    private val nombre: String,
    private val telefono: String
) {
    fun datos(): String {
        return "$nombre\nCI: $ci\nTeléfono: $telefono"
    }
}