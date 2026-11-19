package com.example.farmacia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmacia.modelo.Cliente
import com.example.farmacia.modelo.Medicamento
import com.example.farmacia.modelo.Producto
import com.example.farmacia.modelo.ProductoHigiene
import com.example.farmacia.ui.theme.FarmaciaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FarmaciaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppFarmacia(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// ---------- Datos de ejemplo ----------

fun obtenerProductos(): List<Producto> {
    return listOf(
        Medicamento("M001", "Paracetamol 500mg", 15.0, 50, "Bagó", false),
        Medicamento("M002", "Amoxicilina 500mg", 35.0, 20, "Inti", true),
        ProductoHigiene("H001", "Jabón antibacterial", 8.5, 0, "Protex")
    )
}

fun obtenerClientes(): List<Cliente> {
    return listOf(
        Cliente("1234567", "Juan Pérez", "70011223"),
        Cliente("7654321", "María Quispe", "71122334"),
        Cliente("4567890", "Carlos Mamani", "72233445")
    )
}

// ---------- App principal ----------

@Composable
fun AppFarmacia(modifier: Modifier = Modifier) {
    val pantalla = remember { mutableStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Farmacia Bolivia",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { pantalla.value = 1 },
                modifier = Modifier.weight(1f)
            ) {
                Text("Productos")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { pantalla.value = 2 },
                modifier = Modifier.weight(1f)
            ) {
                Text("Clientes")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (pantalla.value == 1) {
            PantallaProductos()
        } else {
            PantallaClientes()
        }
    }
}

// ---------- Pantalla 1: Productos ----------

@Composable
fun PantallaProductos() {
    val productos = obtenerProductos()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Lista de Productos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        for (producto in productos) {
            TarjetaProducto(producto)
        }
    }
}

@Composable
fun TarjetaProducto(producto: Producto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = producto.descripcion())

            Spacer(modifier = Modifier.height(4.dp))

            if (producto.hayStock()) {
                Text(
                    text = "Disponible",
                    color = Color(0xFF2E7D32),
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text(
                    text = "Sin stock",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// ---------- Pantalla 2: Clientes ----------

@Composable
fun PantallaClientes() {
    val clientes = obtenerClientes()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Lista de Clientes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        for (cliente in clientes) {
            TarjetaCliente(cliente)
        }
    }
}

@Composable
fun TarjetaCliente(cliente: Cliente) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = cliente.datos())
        }
    }
}

// ---------- Previews ----------

@Preview(showBackground = true)
@Composable
fun AppFarmaciaPreview() {
    FarmaciaTheme {
        AppFarmacia()
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaProductosPreview() {
    FarmaciaTheme {
        PantallaProductos()
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaClientesPreview() {
    FarmaciaTheme {
        PantallaClientes()
    }
}