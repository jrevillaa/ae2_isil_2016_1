package parcial.beans;

import java.io.Serializable;

public class Producto implements Serializable{
    /*
     Cod_pro   | varchar(4)
Des_pro   | varchar(25)
Pre_pro   | double(7,2)
Stk_act   | int(10)
Stk_min   | int(10)
Lin_pro   | varchar(1)
Importado | tinyint(1)
    */
    private String Cod_pro;
    private String Des_pro;
    private double Pre_pro;
    private int Stk_act;
    private int Stk_min;
    private String Lin_pro;
    private int Importado;
    public Producto() {
    }

    public Producto(String codigo, String descripcion, double precio, int stock, int stock_min, String Lin_pro, int importado) {
        this.Cod_pro = codigo;
        this.Des_pro = descripcion;
        this.Pre_pro = precio;
        this.Stk_act = stock;
        this.Stk_min = stock_min;
        this.Lin_pro = Lin_pro;
        this.Importado = importado;
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
     * @return the Des_pro
     */
    public String getDes_pro() {
        return Des_pro;
    }

    /**
     * @param Des_pro the Des_pro to set
     */
    public void setDes_pro(String Des_pro) {
        this.Des_pro = Des_pro;
    }

    /**
     * @return the Pre_pro
     */
    public double getPre_pro() {
        return Pre_pro;
    }

    /**
     * @param Pre_pro the Pre_pro to set
     */
    public void setPre_pro(double Pre_pro) {
        this.Pre_pro = Pre_pro;
    }

    /**
     * @return the Stk_act
     */
    public int getStk_act() {
        return Stk_act;
    }

    /**
     * @param Stk_act the Stk_act to set
     */
    public void setStk_act(int Stk_act) {
        this.Stk_act = Stk_act;
    }

    /**
     * @return the Stk_min
     */
    public int getStk_min() {
        return Stk_min;
    }

    /**
     * @param Stk_min the Stk_min to set
     */
    public void setStk_min(int Stk_min) {
        this.Stk_min = Stk_min;
    }

    /**
     * @return the Lin_pro
     */
    public String getLin_pro() {
        return Lin_pro;
    }

    /**
     * @param Lin_pro the Lin_pro to set
     */
    public void setLin_pro(String Lin_pro) {
        this.Lin_pro = Lin_pro;
    }

    /**
     * @return the Importado
     */
    public int getImportado() {
        return Importado;
    }

    /**
     * @param Importado the Importado to set
     */
    public void setImportado(int Importado) {
        this.Importado = Importado;
    }
    



   

}
