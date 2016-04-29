package dsw2.beans;

import java.util.Vector;


public class Orden {

    private int orden;
    private String fecha;
    private double monto;
    private String estado;
    private int  ccliente;

    private Vector<DetalleOrden> detalles;

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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the ccliente
     */
    public int getCcliente() {
        return ccliente;
    }

    /**
     * @param ccliente the ccliente to set
     */
    public void setCcliente(int ccliente) {
        this.ccliente = ccliente;
    }

    /**
     * @return the detalles
     */
    public Vector<DetalleOrden> getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(Vector<DetalleOrden> detalles) {
        this.detalles = detalles;
    }




}
