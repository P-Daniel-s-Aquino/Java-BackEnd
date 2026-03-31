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

        Producto p1 = new Producto("Ruedas de auxilio", 230000);
        Cliente c1 = new Cliente("Martin P.");
        Venta v1 = new Venta(c1, p1, 2);
        System.out.println(v1);

        Producto p2 = new Producto("Kit de Herramientas Pro", 85000);
        Cliente c2 = new Cliente("Sabrina G.");
        Venta v2 = new Venta(c2, p2, 1);
        System.out.println(v2);

        Producto p3 = new Producto("Aceite Sintético 5L", 45000);
        Cliente c3 = new Cliente("Matías L.");
        Venta v3 = new Venta(c3, p3, 4);
        System.out.println(v3);

        Producto p4 = new Producto("Lámpara LED H4", 12500);
        Cliente c4 = new Cliente("Ana F.");
        Venta v4 = new Venta(c4, p4, 2);
        System.out.println(v4);
        
        Producto p5 = new Producto("Filtro de Aire K&N", 55000);
        Venta v5 = new Venta(c1, p5, 1);
        System.out.println(v5);

        Producto p6 = new Producto("Lampara Solar", 1230);
        Venta v6 = new Venta(c2, p6, 101);
        System.out.println(v6);
    }
}