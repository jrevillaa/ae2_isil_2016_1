package dsw2.beans;


public class DetalleOrden {
    private int orden;
    private int cproducto;
    private int cantidad;
    private double precio;

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }

    /**
     * @return the cproducto
     */
    public int getCproducto() {
        return cproducto;
    }

    /**
     * @param cproducto the cproducto to set
     */
    public void setCproducto(int cproducto) {
        this.cproducto = cproducto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
