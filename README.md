# TechLab – Gestión de Artículos

Proyecto Java de consola para la pre-entrega. Administra artículos de un catálogo, separados por tipo (alimenticio y electrónico), con categorías, cálculo de precios e identificación única.

## Objetivo
Practicar herencia, interfaces y separación por capas en Java puro, sin frameworks.

## Estructura

```
consignaPreEntrega/
└── src/com/techlab/
    ├── App.java
    ├── interfaces/
    │   ├── Calculable.java
    │   └── Identificable.java
    ├── menu/
    │   ├── Menu.java
    │   ├── MenuArticulos.java
    │   └── MenuCategorias.java
    ├── model/
    │   ├── Articulo.java
    │   ├── ArticuloAlimenticio.java
    │   ├── ArticuloElectronico.java
    │   └── Categoria.java
    ├── repository/
    │   └── Repositorio.java
    └── utils/
        ├── Secuencias.java
        └── Validaciones.java
```

## Qué hace cada paquete

**interfaces**
- `Calculable`: define el contrato para calcular precio final, descuentos o impuestos.
- `Identificable`: asegura que cada entidad exponga un ID único.

**model**
- `Articulo`: clase abstracta base. Guarda nombre, precio base, stock y categoría.
- `ArticuloAlimenticio`: extiende Articulo. Agrega fecha de vencimiento y manejo de perecibles.
- `ArticuloElectronico`: extiende Articulo. Agrega garantía y consumo energético.
- `Categoria`: agrupa artículos y facilita filtros.

**repository**
- `Repositorio`: almacenamiento en memoria (List). CRUD básico para artículos y categorías.

**menu**
- `Menu`: clase abstracta con el loop principal.
- `MenuArticulos`: alta, baja, modificación y listado de artículos.
- `MenuCategorias`: gestión de categorías.

**utils**
- `Secuencias`: generador simple de IDs autoincrementales.
- `Validaciones`: chequeos de entrada (números positivos, strings no vacíos, fechas).

**App.java**
Punto de entrada. Instancia el repositorio y lanza el menú principal.

## Tecnologías
- Java 17+
- Paradigma OOP
- Sin dependencias externas

## Cómo ejecutar

1. Clonar o descargar el proyecto.
2. Compilar desde la raíz:
   ```bash
   cd consignaPreEntrega/src
   javac com/techlab/**/*.java -d out
   ```
3. Ejecutar:
   ```bash
   java -cp out com.techlab.App
   ```

En IDE (IntelliJ, Eclipse, VS Code): marcar `src` como source root y correr `App.java`.

## Flujo típico
1. Crear categorías en MenuCategorias.
2. Cargar artículos alimenticios o electrónicos.
3. El sistema asigna ID vía `Secuencias` y valida datos con `Validaciones`.
4. Consultar listado, calcular precio final con `Calculable`.

## Próximos pasos sugeridos
- Persistencia en archivo o base de datos.
- Implementar descuentos por categoría en `Calculable`.
- Tests unitarios para `ArticuloAlimenticio` y `ArticuloElectronico`.
- Exportar catálogo a CSV.

---
Hecho para la consigna de pre-entrega – TechLab 2026.
