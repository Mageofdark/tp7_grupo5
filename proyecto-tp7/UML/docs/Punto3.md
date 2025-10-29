# Punto 3 – Trabajo Práctico N°7 - Grupo 5

### a) ¿Por qué no se dibuja la relación de agregación entre la clase CollectionProducto y Producto?
No se dibuja la relacion de agregacion porque CollectionProducto gestiona internamente una lista de objetos Producto, pero sin mantener una relación directa ni de dependencia entre ellos.

### b) ¿Cuántos atributos tiene la clase Factura? ¿Cuáles son los nombres de esos atributos?
La clase Factura tiene 2 atributos: `fecha` y `nroFactura`.

### c) ¿Cómo se llama la relación que se establece entre Factura y Detalle?
La relacion entre las clases Factura y Detalle se llama `composicion`.

### d) ¿Cómo se llama la relación entre las clases Factura y Cliente?
La relacion entre las clases Factura y Cliente se llama `asociacion`.

### e) ¿Por qué los atributos de las clases Collections son públicos?
Los atributos de las clases collection son publicos para simplificar el acceso o manipulación desde otras clases (como agregar, buscar o listar elementos).

### f) Describa las características de todos los métodos de la clase CollectionClientes.
+agregarCliente(in cliente: Cliente) :
Recibe una objeto de tipo cliente como parametro 
Su objetivo es agregar el cliente a la collection
No devuelve ningun valor

+buscarPorDNI (in dni: long) : Cliente :
Recibe una valor de tipo long 
Su objetivo de buscar un cliente en la collection segun su DNI
Devuelve una objeto de tipo Cliente

+precargarClientes() :
No recibe ningun parametro
Su funcion es solo precargar la collection con una lista de clientes predefinida (esto solo ocurre al iniciar el proyecto)
No devuelve nada
