package parcial.beans;


public class DetalleOrden {

    /*
    Num_fac | varchar(5)
    Cod_pro | varchar(4)
    Can_ven | int(10)
    Pre_ven | double(7,2)
    */
    
    private String Num_fac;
    private String Cod_pro;
    private int Can_ven;
    private double Pre_ven;

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
     * @return the Cod_pro
     */
    public String getCod_pro() {
        return Cod_pro;
    }

    /**
     * @param Cod_pro the Cod_pro to set
     */
    public void setCod_pro(String Cod_pro) {
        this.Cod_pro = Cod_pro;
    }

    /**
     * @return the Can_ven
     */
    public int getCan_ven() {
        return Can_ven;
    }

    /**
     * @param Can_ven the Can_ven to set
     */
    public void setCan_ven(int Can_ven) {
        this.Can_ven = Can_ven;
    }

    /**
     * @return the Pre_ven
     */
    public double getPre_ven() {
        return Pre_ven;
    }

    /**
     * @param Pre_ven the Pre_ven to set
     */
    public void setPre_ven(double Pre_ven) {
        this.Pre_ven = Pre_ven;
    }

    
}
