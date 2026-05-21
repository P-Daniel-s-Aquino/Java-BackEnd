# TechLab – Gestión de Artículos

> Sistema de consola en Java 17+ para administrar un catálogo de artículos, aplicando herencia, interfaces y separación por capas.

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Pre--Entrega-success?style=for-the-badge)
![Paradigm](https://img.shields.io/badge/Paradigm-OOP-blue?style=for-the-badge)
![Build](https://img.shields.io/badge/Build-Manual-lightgrey?style=for-the-badge)

## 🎯 Objetivo Académico

Este proyecto es de TechLab.

- **Herencia:** `Articulo` (abstracta) → `ArticuloAlimenticio` / `ArticuloElectronico`
- **Interfaces:** `Identificable` (contrato de ID) y `Calculable` (contrato de precio final)
- **Polimorfismo:** cada subclase calcula su precio final de forma distinta
- **Encapsulamiento:** atributos privados, acceso por getters/setters
- **Separación de responsabilidades:** `model` / `repository` / `menu` / `utils` / `interfaces`

> Sin frameworks, sin base de datos, sin librerías externas. Solo JDK.

## ✨ Características Principales

- **CRUD completo de artículos** desde consola
- **Dos tipos de artículo con lógica propia:**
  - **Alimenticio:** registra `diasParaVencimiento`. Si vence en < 15 días, aplica lógica especial en `calcularPrecioFinal()`
  - **Electrónico:** registra `garantiaMeses`. Aplica IVA 21% en `calcularPrecioFinal()`
- **Categorías como `enum`** – Electrónica, Periféricos, Alimentos, Limpieza. Inmutables y tipadas.
- **ID autoincremental** gestionado dentro de `Articulo` (no se pide al usuario)
- **Menús separados** que heredan de una clase base `Menu`
- **Validaciones centralizadas** para evitar entradas inválidas
- **Repositorio genérico en memoria** `<T extends Identificable>`

## 🏗️ Arquitectura

```
com.techlab.articulo/
│
├── App.java                 // Punto de entrada
│
├── interfaces/
│   ├── Identificable.java   // int getCodigo()
│   └── Calculable.java      // double calcularPrecioFinal()
│
├── model/
│   ├── Articulo.java              // abstract, implementa ambas interfaces
│   ├── ArticuloAlimenticio.java   // + diasParaVencimiento
│   ├── ArticuloElectronico.java   // + garantiaMeses
│   └── Categoria.java             // enum con código, nombre, descripción
│
├── repository/
│   └── Repositorio.java     // List<T>, CRUD general
│
├── menu/
│   ├── Menu.java            // abstract, lectura segura
│   ├── MenuArticulos.java   // ABM artículos
│   └── MenuCategorias.java  // consulta de enum
│
└── utils/
    └── Validaciones.java    // texto no vacío, longitud, no negativo
```

## 🧠 Modelo de Dominio

### `Articulo` (abstracta)
```
codigo (auto) | nombre | precio | categoria
```
- `codigo` se genera con `private static int contador`
- Define `toString()` base

### `ArticuloAlimenticio`
Añade `diasParaVencimiento`. Su `calcularPrecioFinal()` puede aplicar lógica de perecibles.

### `ArticuloElectronico`
Añade `garantiaMeses`. Su `calcularPrecioFinal()` aplica IVA.

### `Categoria` (enum)
```java
ELECTRONICA(1, "Electrónica", "Dispositivos electrónicos"),
PERIFERICOS(2, "Periféricos", "Accesorios de PC"),
ALIMENTOS(3, "Alimentos", "Productos alimenticios"),
CONGELADOS(4, "Congelados", "Productos alimenticios congelados");
```
Incluye `buscarPorCodigo(int)` que lanza excepción si no existe.

## 🔧 Decisiones de Diseño (lo que cambió vs. la consigna)

| Tema | Consigna original | Mi implementación | Razón |
| :--- | :--- | :--- | :--- |
| **Categorías** | Clase + `Repositorio<Categoria>` + `precargarCategorias()` | `enum Categoria` | Son valores fijos del dominio. El enum evita errores, no necesita persistencia y da seguridad de tipos. |
| **ID de Artículo** | Ingresado por usuario + `Secuencias` | Contador estático en `Articulo` | Garantiza unicidad, simplifica el alta, elimina clase utilitaria. |
| **MenuCategorias** | ABM completo | Solo lectura | Al ser enum, no se puede crear/borrar en runtime. |
| **Validaciones** | Dispersas | Clase `Validaciones` final | Reutilizable y testeable. |

> **Resultado:** `App.java` ya no instancia `Repositorio<Categoria>`.

## 🚀 Instalación y Ejecución

**Requisitos:** JDK 17+

**En IntelliJ / VS Code:** Marcar `src` como Sources Root → Run `App.java`

## 🕹️ Uso del Sistema

```
======================================================
 SISTEMA DE ARTÍCULOS - CLASE 8 (MENÚS SEPARADOS)
======================================================
1 - Menú de artículos
2 - Menú de categorías
0 - Salir
```

**Menú Artículos:**
1. Agregar → elige tipo → completa datos → categoría se elige por código del enum
2. Listar → `lista.forEach(System.out::println)`
3. Buscar → muestra precio final polimórfico
4. Modificar → cambia nombre, precio, categoría o campo específico
5. Eliminar
6. Listar por categoría

**Menú Categorías:**
- Solo lista las 4 constantes del enum y permite filtrar artículos.

## ✅ Validaciones Implementadas

`Validaciones.java`:
- `validarTextoNoVacio(String)` – evita nombres vacíos
- `validarLongitudMaxima(String, 50)` – límite de UI
- `validarNoNegativo(int/double)` – precios, garantía y días

Todas las lecturas en `Menu` usan `scanner.nextLine()` para evitar el bug del buffer.

## 🧪 Ejemplo de Salida

```
--- MENÚ ARTÍCULOS ---
1 - Agregar artículo
> 1
Tipo: 1-Electrónico  2-Alimenticio
Tipo: 1
Nombre: Mouse Gamer
Precio: 25000
Categorías disponibles:
1 - Electrónica
2 - Periféricos
Código categoría: 2
Garantía en meses: 24
Artículo agregado con código: 1

2 - Teclado Mecánico | $45000.00 | Cat: PERIFERICOS | Garantía: 24 meses
Precio final: $54450.00
```
