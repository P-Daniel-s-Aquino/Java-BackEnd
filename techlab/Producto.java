public class Producto {
    
    private String nombre;
    private double precio;
    private int stockInicial;
    public Object inventario;

    public Producto(String nombre, double precio, int stockInicial) {
        this.nombre = nombre;
        this.precio = precio;
        this.stockInicial = stockInicial;
    }

    // --- Getters y Setters ---
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) { // Corregido a double
        this.precio = precio;
    }

    public int getstockInicial() {
        return stockInicial;
    }

    public boolean hayStockSuficiente(int cantidad) {
        return this.stockInicial >= cantidad;
    }

    public void reducirStockInicial(int cantidad) {
        if (hayStockSuficiente(cantidad)) {
            this.stockInicial -= cantidad;
        }
    }
    
    @Override
    public String toString() {
        return "Producto: " + this.nombre + " | Precio: $" + this.precio + " | stockInicial: " + this.stockInicial;
    }
}