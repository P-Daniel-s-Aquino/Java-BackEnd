public class Venta {
    
    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    
    public Venta(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularPrecioTotal() {
        if(this.cantidad > 100) {
            System.out.println("Se generea un -30%");
            return this.producto.getPrecio() * 0.7 * this.cantidad; 
        }
        return this.producto.getPrecio() * this.cantidad;
    }

    @Override
    public String toString() {
        return (
            "=============== VENTA ===============" +
            "\nNombre del cliente: " + this.cliente.getNombre() +
            "\nNombre del producto: " + this.producto.getNombre() +
            "\nPrecio unitario: " + this.producto.getPrecio() +
            "\nCantidad a comprar: " + this.cantidad +
            "\n--------------------------------------------" +
            "\nPrecio total a pagar: " + this.calcularPrecioTotal() +
            "\n--------------------------------------------\n\n"
        );
    }
}
