# Scripts usados en el examen – Primer Parcial Programación III

**Estudiante:** Kadir Felipe Miranda Laura
**Herramienta de IA:** Claude (Anthropic)
**Caso de estudio:** Farmacia

---

## 1. Prompts utilizados con la IA

### Prompt 1 – Contexto inicial
> Soy Kadir, estudiante de Ingeniería de Sistemas en la UPB. Hoy tengo un examen individual de Programación 3 donde el docente permite usar IA. Estoy aprendiendo a desarrollar apps en Android Studio con Kotlin y Jetpack Compose (Material3). Respóndeme en español, dame el código completo y listo para copiar y pegar, dime en qué archivo va y qué imports agregar, y luego una explicación corta de cómo funciona.

### Prompt 2 – Checkpoint 1: Diseño de clases
> (Se adjuntó el PDF del examen) Esto es lo que tenemos que hacer, comencemos.

**Resultado:** se eligió el caso Farmacia y se diseñaron las clases Producto (abstracta), Medicamento, ProductoHigiene, Cliente, DetalleVenta, Venta y Farmacia, con relaciones de herencia, asociación, composición y agregación. El diagrama se hizo en draw.io (`docs/diagrama_clases.png`) y en Mermaid (`README.md`).

### Prompt 3 – Checkpoint 2: Implementación
> Creé el diagrama en draw.io, ya hice el README. Te paso el repositorio: https://github.com/kadirmirandalaura12-cpu/Farmacia. Sigamos con el siguiente paso.

**Resultado:** se implementaron las 7 clases en Kotlin en el paquete `com.example.farmacia.modelo`, aplicando herencia, abstracción, polimorfismo y encapsulamiento. Se ajustó el diagrama: los atributos de Producto pasaron a `protected (#)` y se agregó `obtenerPrecio()`.

### Prompt 4 – Checkpoint 3: Scripts
> Ya hice add, commit y push, vamos con lo siguiente.

**Resultado:** se creó este archivo con los scripts usados.

---

## 2. Comandos de Git utilizados

```bash
# Configuración inicial y subida del proyecto
git init
git branch -M main
git remote add origin https://github.com/kadirmirandalaura12-cpu/Farmacia.git
git add .
git commit -m "Checkpoint 1 - Diagrama de clases"
git push -u origin main

# Checkpoint 2
git add .
git commit -m "Checkpoint 2 - Implementacion de clases"
git push

# Checkpoint 3
git add .
git commit -m "Checkpoint 3 - Scripts usados en el examen"
git push
``` 