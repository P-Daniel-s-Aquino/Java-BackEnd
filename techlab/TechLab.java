// En TechLab, Silvia (Product Owner) ha recibido nuevas solicitudes del cliente “Sibelius”. 
// El equipo de desarrollo (Matías y Sabrina) se enfrenta a varios pequeños problemas cotidianos del proyecto de e-commerce. 
// Cada uno de estos problemas se resolverá aplicando un concepto de programación. 
// Los problemas que enfrentaremos en TalentoLab esta semana son los siguientes:
// Necesitamos llevar un registro del stock de productos.
// El cliente quiere saber el costo total de un pedido sumando el precio unitario por la cantidad de productos.
// Requerimos solicitar datos al cliente para personalizar la experiencia.
// Debemos verificar si tenemos suficiente stock para cubrir una demanda específica.
// Hay que procesar una lista de productos pendientes de revisión. Primero intentaremos una solución con while 
// y luego notaremos que for podría ser más elegante.

// Para cumplir con necesidades el equipo de desarrollo (Matías, Sabrina) y vos deberán:
// Variables y Operadores:
// Creá variables para representar el precio de un producto y la cantidad deseada por el cliente. 
// Calculá y mostrale en pantalla el costo total.
// Modificá el precio o la cantidad y verificá el resultado.
// Entrada y Salida de Datos:
// Pedile al usuario que ingrese su nombre y la cantidad de productos que quiere comprar.
// Mostrá un mensaje personalizado con el monto total (asignando un precio fijo por unidad).

// Condicionales:
// Suponé que si el cliente quiere más de 100 unidades, le ofrecemos un descuento.
// Implementá un if que verifique si cantidad > 100. Si es así, mostrá un mensaje 
// indicando que aplica un descuento especial.
// Bucles:
// Pedile al usuario que ingrese un número, y luego usá un bucle for para imprimir 
// desde 1 hasta ese número.
// Repetí lo mismo con un while y compará cuál te resulta más intuitivo.

public class TechLab {
    public static void main(String[] args) {

        // --- 1. Cargar el inventario de la tienda ---
        Venta.agregarProducto(new Producto("Ruedas de auxilio", 120000, 176));
        Venta.agregarProducto(new Producto("Kit de Herramientas", 80000, 200));
        Venta.agregarProducto(new Producto("Lampara led H4", 72349, 50));
        Venta.agregarProducto(new Producto("Filtro de Aire K&G", 29820, 700));
        Venta.agregarProducto(new Producto("Liquido de Frenos PG5l00", 35500, 905));
        Venta.agregarProducto(new Producto("Bujia Iridium", 18000, 40));

        System.out.println("--- INVENTARIO INICIAL ---");
        Venta.mostrarCatalogo();

        // --- 2. Ingresar a los clientes ---
        Cliente c1 = new Cliente("Martin P.");
        Cliente c2 = new Cliente("Sabrina G.");
        Cliente c3 = new Cliente("Aramis G.");
        Cliente c4 = new Cliente("Enzo C.");
        Cliente c5 = new Cliente("Belen A.");

        System.out.println("\n--- PROCESANDO VENTAS ---\n");

        // --- Primera ronda de ventas ---
        Venta v1 = new Venta(c1, Venta.buscarProducto("Ruedas de auxilio"), 30);
        Venta v2 = new Venta(c2, Venta.buscarProducto("Kit de Herramientas"), 101);
        Venta v3 = new Venta(c3, Venta.buscarProducto("Lampara led H4"), 2);
        Venta v4 = new Venta(c4, Venta.buscarProducto("Filtro de Aire K&G"), 8);
        Venta v5 = new Venta(c5, Venta.buscarProducto("Liquido de Frenos PG5l00"), 10);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
        
        // --- Más ventas para probar la lógica de stock ---

        // Venta 6: Exitosa, un cliente vuelve a comprar
        Venta v6 = new Venta(c1, Venta.buscarProducto("Bujia Iridium"), 4);
        System.out.println(v6);

        // Venta 7: FALLIDA, se intenta comprar más lámparas de las que hay en stock
        Venta v7 = new Venta(c3, Venta.buscarProducto("Lampara led H4"), 50); // Solo quedan 48
        System.out.println(v7);

        // Venta 8: Exitosa, prueba del descuento por comprar más de 100 unidades
        Venta v8 = new Venta(c4, Venta.buscarProducto("Filtro de Aire K&G"), 120);
        System.out.println(v8);

        // Venta 9: FALLIDA, el producto no existe en el catálogo
        Producto p9 = new Producto("Bateria de Gel", 95000, 10);
        Venta v9 = new Venta(c5, p9, 1); // Este producto nunca se agregó al inventario
        System.out.println(v9); // Esto funcionará, pero la lógica de stock no es la del inventario central

        // Venta 10: Exitosa, se vende casi todo el stock de un producto
        Venta v10 = new Venta(c2, Venta.buscarProducto("Bujia Iridium"), 35); // Quedaban 36, ahora quedará 1
        System.out.println(v10);
        
        // --- 3. Revisar el estado final del inventario ---
        System.out.println("\n--- INVENTARIO FINAL ---");
        Venta.mostrarCatalogo();
    }
}