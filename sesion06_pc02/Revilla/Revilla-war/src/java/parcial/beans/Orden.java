package parcial.beans;

import java.util.Date;
import java.util.Vector;


public class Orden {

    /*
    Num_fac | varchar(5)
    Fec_fac | datetime
    Cod_cli | varchar(4)
    Fec_can | datetime
    Est_fac | varchar(50
    Cod_ven | varchar(3)
    */
    
    private String Num_fac;
    private Date Fec_fac;
    private String Cod_cli;
    private Date Fec_can;
    private String Est_fac;
    private String Cod_ven;

    private Vector<DetalleOrden> detalles;



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

    /**
     * @return the Num_fac
     */
    public String getNum_fac() {
        return Num_fac;
    }

    /**
     * @param Num_fac the Num_fac to set
     */
    public void setNum_fac(String Num_fac) {
        this.Num_fac = Num_fac;
    }

    /**
     * @return the Fec_fac
     */
    public Date getFec_fac() {
        return Fec_fac;
    }

    /**
     * @param Fec_fac the Fec_fac to set
     */
    public void setFec_fac(Date Fec_fac) {
        this.Fec_fac = Fec_fac;
    }

    /**
     * @return the Cod_cli
     */
    public String getCod_cli() {
        return Cod_cli;
    }

    /**
     * @param Cod_cli the Cod_cli to set
     */
    public void setCod_cli(String Cod_cli) {
        this.Cod_cli = Cod_cli;
    }

    /**
     * @return the Fec_can
     */
    public Date getFec_can() {
        return Fec_can;
    }

    /**
     * @param Fec_can the Fec_can to set
     */
    public void setFec_can(Date Fec_can) {
        this.Fec_can = Fec_can;
    }

    /**
     * @return the Est_fac
     */
    public String getEst_fac() {
        return Est_fac;
    }

    /**
     * @param Est_fac the Est_fac to set
     */
    public void setEst_fac(String Est_fac) {
        this.Est_fac = Est_fac;
    }

    /**
     * @return the Cod_ven
     */
    public String getCod_ven() {
        return Cod_ven;
    }

    /**
     * @param Cod_ven the Cod_ven to set
     */
    public void setCod_ven(String Cod_ven) {
        this.Cod_ven = Cod_ven;
    }




}
