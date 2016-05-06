package parcial.beans;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable{

/*
Cod_cli
Raz_soc_cli
Dir_cli
Tel_cli
Ruc_cli
Cod_dis
Fec_reg
Tip_cli
Contacto
    */
    private String Cod_cli;
    private String Raz_soc_cli;
    private String Dir_cli;
    private String Tel_cli;
    private String Ruc_cli;
    private String Cod_dis;
    private Date Fec_reg;
    private String Tip_cli;
    private String Contacto;

    public String getCod_cli() {
        return Cod_cli;
    }

    public void setCod_cli(String Cod_cli) {
        this.Cod_cli = Cod_cli;
    }

    public String getRaz_soc_cli() {
        return Raz_soc_cli;
    }

    public void setRaz_soc_cli(String Raz_soc_cli) {
        this.Raz_soc_cli = Raz_soc_cli;
    }

    public String getDir_cli() {
        return Dir_cli;
    }

    public void setDir_cli(String Dir_cli) {
        this.Dir_cli = Dir_cli;
    }

    public String getTel_cli() {
        return Tel_cli;
    }

    public void setTel_cli(String Tel_cli) {
        this.Tel_cli = Tel_cli;
    }

    public String getRuc_cli() {
        return Ruc_cli;
    }

    public void setRuc_cli(String Ruc_cli) {
        this.Ruc_cli = Ruc_cli;
    }

    public String getCod_dis() {
        return Cod_dis;
    }

    public void setCod_dis(String Cod_dis) {
        this.Cod_dis = Cod_dis;
    }

    public Date getFec_reg() {
        return Fec_reg;
    }

    public void setFec_reg(Date Fec_reg) {
        this.Fec_reg = Fec_reg;
    }

    public String getTip_cli() {
        return Tip_cli;
    }

    public void setTip_cli(String Tip_cli) {
        this.Tip_cli = Tip_cli;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }
   



}