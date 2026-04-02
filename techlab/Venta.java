import java.util.ArrayList;
import java.util.List;

public class Venta {

    private static List<Producto> inventario = new ArrayList<>();

    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private boolean completada;

    public Venta(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        
        if (producto.hayStockSuficiente(cantidad)) {
            producto.reducirStockInicial(cantidad);
            this.completada = true;
        } else {
            this.completada = false;
        }
    }

    public static List<Producto> getInventario() {
        return inventario;
    }

    public static void setInventario(List<Producto> inventario) {
        Venta.inventario = inventario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public static void agregarProducto(Producto producto) {
        inventario.add(producto);
        System.out.println("Producto '" + producto.getNombre() + "' agregado al catálogo.");
    }

    public static void mostrarCatalogo() {
        System.out.println("\n===== CATÁLOGO DE LA TIENDA =====");
        for (Producto p : inventario) {
            System.out.println(p);
        }
        System.out.println("=================================\n");
    }

    public static Producto buscarProducto(String nombre) {
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public double calcularPrecioTotal() {
        if (!this.completada) {
            return 0; // Si la venta falló, no hay costo.
        }
        
        // Lógica del descuento por cantidad
        if (this.cantidad > 100) {
            return this.producto.getPrecio() * 0.7 * this.cantidad; 
        }
        
        return this.producto.getPrecio() * this.cantidad;
    }

@Override
public String toString() {
    if (!this.completada) {
        return (
            "\n=============== VENTA FALLIDA ===============" +
            "\nCliente: " + this.cliente.getNombre() + // Usamos getNombre() para más claridad
            "\nProducto solicitado: " + this.producto.getNombre() +
            "\nCantidad solicitada: " + this.cantidad +
            "\nMotivo: Stock insuficiente. (Disponible: " + this.producto.getstockInicial() + ")" +
            "\n=============================================\n"
        );
    }

    // Si la venta SÍ se completó, muestra un recibo detallado.
    String notaDescuento = (this.cantidad > 100) ? " (Descuento del 30% aplicado)" : "";

    return (
        "\n=============== RECIBO DE VENTA ===============" +
        "\nCliente: " + this.cliente.getNombre() +
        "\n---------------------------------------------" +
        "\nProducto: " + this.producto.getNombre() +
        "\nPrecio Unitario: $" + this.producto.getPrecio() +
        "\nCantidad: " + this.cantidad +
        "\n---------------------------------------------" +
        "\nTotal a Pagar: $" + this.calcularPrecioTotal() + notaDescuento +
        "\n=============================================\n"
    );
}

}