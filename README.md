# Farmacia App – Primer Parcial Programación III

**Estudiante:** Kadir Felipe Miranda Laura
**Caso de estudio:** Farmacia

## Checkpoint 1 – Modelo de clases

![Diagrama de clases](docs/diagrama_clases.png)

```mermaid
classDiagram
    class Producto {
        <<abstract>>
        -codigo: String
        -nombre: String
        -precio: Double
        -stock: Int
        +hayStock() Boolean
        +descripcion()* String
    }

    class Medicamento {
        -laboratorio: String
        -requiereReceta: Boolean
        +descripcion() String
    }

    class ProductoHigiene {
        -marca: String
        +descripcion() String
    }

    class Cliente {
        -ci: String
        -nombre: String
        -telefono: String
        +datos() String
    }

    class DetalleVenta {
        -producto: Producto
        -cantidad: Int
        +subtotal() Double
    }

    class Venta {
        -id: Int
        -cliente: Cliente
        -detalles: List~DetalleVenta~
        +agregarDetalle(detalle: DetalleVenta)
        +total() Double
    }

    class Farmacia {
        -nombre: String
        -productos: List~Producto~
        -clientes: List~Cliente~
        +agregarProducto(producto: Producto)
        +agregarCliente(cliente: Cliente)
    }

    Producto <|-- Medicamento : herencia
    Producto <|-- ProductoHigiene : herencia
    Venta "1" --> "1" Cliente : asociación
    Venta "1" *-- "1..*" DetalleVenta : composición
    DetalleVenta "1" --> "1" Producto : asociación
    Farmacia "1" o-- "0..*" Producto : agregación
    Farmacia "1" o-- "0..*" Cliente : agregación
```

### Descripción de las clases
| Clase | Responsabilidad |
|---|---|
| Producto (abstracta) | Datos comunes de todo producto: código, nombre, precio y stock. |
| Medicamento | Producto con laboratorio y si requiere receta. |
| ProductoHigiene | Producto de cuidado personal con marca. |
| Cliente | Persona que compra en la farmacia. |
| DetalleVenta | Un producto vendido con su cantidad y subtotal. |
| Venta | Compra de un cliente, formada por uno o más detalles. |
| Farmacia | Contiene la lista de productos y clientes. |

### Conceptos de POO aplicados
- **Herencia:** Medicamento y ProductoHigiene heredan de Producto.
- **Abstracción:** Producto es abstracta y obliga a implementar `descripcion()`.
- **Polimorfismo:** cada subclase implementa `descripcion()` a su manera.
- **Encapsulamiento:** atributos privados (`-`) con métodos públicos (`+`).