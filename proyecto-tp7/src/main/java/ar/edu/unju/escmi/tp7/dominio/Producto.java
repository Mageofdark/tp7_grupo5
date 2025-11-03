package ar.edu.unju.escmi.tp7.dominio;

import ar.edu.unju.escmi.tp7.collections.CollectionStock;

public class Producto {
	private long codigo;
    private String descripcion;
    private double precioUnitario;
    private String origenFabricacion;


    public Producto() {

    }

    public Producto(long codigo, String descripcion, double precioUnitario, String origenFabricacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.origenFabricacion = origenFabricacion;
    }


    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
    public String getOrigenFabricacion() {
        return origenFabricacion;
    }

    public void setOrigenFabricacion(String origenFabricacion) {
        this.origenFabricacion = origenFabricacion;
    }

    //obtener el stock del producto
    public int getStock() {
        Stock stock = CollectionStock.buscarStock(this);
        if (stock != null) {
            return stock.getCantidad();
        }
        return 0; // Si no se encuentra el stock, se asume que es 0
    }

    
    @Override
    public String toString() {
        return "Codigo: " + codigo + " Descripcion: " + descripcion + " Precio Unitario: " + precioUnitario
                + " Origen fabricacion: " + origenFabricacion;
    }
}
