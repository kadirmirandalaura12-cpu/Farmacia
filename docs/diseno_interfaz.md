# Checkpoint 4 – Diseño de Interfaz

**Estudiante:** Kadir Felipe Miranda Laura
**Caso de estudio:** Farmacia

La aplicación tiene **dos pantallas**:
1. **Productos:** lista objetos de las clases `Medicamento` y `ProductoHigiene` (hijas de `Producto`).
2. **Clientes:** lista objetos de la clase `Cliente`.

Para cambiar de pantalla se usan dos botones en la parte superior.

---

## Pantalla 1 – Productos

```
┌─────────────────────────────────┐
│        Farmacia Bolivia         │  ← Text (título)
│  [ Productos ]   [ Clientes ]   │  ← Row con 2 Button
├─────────────────────────────────┤
│ Lista de Productos              │  ← Text (subtítulo)
│ ┌─────────────────────────────┐ │
│ │ Paracetamol 500mg (M001)    │ │
│ │ Laboratorio: Bagó           │ │  ← Card con Text
│ │ Precio: Bs 15.0             │ │    (descripcion())
│ │ Stock: 50                   │ │
│ │ Requiere receta: No         │ │
│ │ Disponible                  │ │  ← Text verde/rojo (hayStock())
│ └─────────────────────────────┘ │
│ ┌─────────────────────────────┐ │
│ │ Amoxicilina 500mg (M002)    │ │
│ │ Laboratorio: Inti           │ │
│ │ Precio: Bs 35.0             │ │
│ │ Stock: 20                   │ │
│ │ Requiere receta: Sí         │ │
│ │ Disponible                  │ │
│ └─────────────────────────────┘ │
│ ┌─────────────────────────────┐ │
│ │ Jabón antibacterial (H001)  │ │
│ │ Marca: Protex               │ │
│ │ Precio: Bs 8.5              │ │
│ │ Stock: 0                    │ │
│ │ Sin stock                   │ │
│ └─────────────────────────────┘ │
│              ↕ scroll           │  ← verticalScroll
└─────────────────────────────────┘
```

## Pantalla 2 – Clientes

```
┌─────────────────────────────────┐
│        Farmacia Bolivia         │  ← Text (título)
│  [ Productos ]   [ Clientes ]   │  ← Row con 2 Button
├─────────────────────────────────┤
│ Lista de Clientes               │  ← Text (subtítulo)
│ ┌─────────────────────────────┐ │
│ │ Juan Pérez                  │ │
│ │ CI: 1234567                 │ │  ← Card con Text
│ │ Teléfono: 70011223          │ │    (datos())
│ └─────────────────────────────┘ │
│ ┌─────────────────────────────┐ │
│ │ María Quispe                │ │
│ │ CI: 7654321                 │ │
│ │ Teléfono: 71122334          │ │
│ └─────────────────────────────┘ │
│ ┌─────────────────────────────┐ │
│ │ Carlos Mamani               │ │
│ │ CI: 4567890                 │ │
│ │ Teléfono: 72233445          │ │
│ └─────────────────────────────┘ │
│              ↕ scroll           │  ← verticalScroll
└─────────────────────────────────┘
```

---

## Componentes de Jetpack Compose utilizados

| Componente | Uso en la app |
|---|---|
| `Column` | Organiza verticalmente el título, los botones y la lista. |
| `Row` | Coloca los dos botones de navegación uno al lado del otro. |
| `Text` | Muestra el título, el subtítulo, la información de cada objeto y el estado del stock. |
| `Button` | Botones "Productos" y "Clientes" para cambiar de pantalla. |
| `Card` (Material3) | Tarjeta que contiene la información de cada producto o cliente. |
| `Spacer` | Espacio entre elementos. |
| `Modifier` | `padding`, `fillMaxSize`, `fillMaxWidth`, `weight` y `verticalScroll` para el tamaño, los márgenes y el desplazamiento. |
| `remember` + `mutableStateOf` | Guarda qué pantalla se está mostrando (1 = Productos, 2 = Clientes). |
| Funciones `@Composable` | `PantallaProductos()`, `PantallaClientes()`, `TarjetaProducto()`, `TarjetaCliente()`. |
| `@Preview` | Vista previa de cada pantalla en Android Studio. |

## Relación con las clases

| Pantalla | Clase(s) | Métodos usados |
|---|---|---|
| Productos | `Medicamento`, `ProductoHigiene` (lista de `Producto`) | `descripcion()` (polimorfismo), `hayStock()` |
| Clientes | `Cliente` | `datos()` |