# Notas UML – Trabajo Práctico N°7

Este archivo detalla ajustes y aclaraciones realizadas al diagrama UML en relación con el código implementado.


## Cambios
Los métodos:

- `consultarCompras(dni: number): List<Factura>`
- `consultarCreditos(dni: number): List<Credito>`

fueron creadas y movidas a sus respectivas collections (`CollectionFactura` y `CollectionCredito`).

El UML de `Cliente` está correcto.


## Ajustes pendientes en el UML

### Credito.java
- Agregar relación de **composición** entre `Credito` -> `Factura`
- Agregar relación **unidireccional muchos a uno** (`* -> 1`) entre `Credito` -> `TarjetaCredito`


### Detalle.java
- Falta agregar relación de **agregación** entre `Detalle` -> `Producto`


### Factura.java
- Falta agregar relación de **agregación** entre `Factura` -> `Cliente`