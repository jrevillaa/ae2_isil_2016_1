package dsw2.beans;

import java.io.Serializable;

public class Cliente implements Serializable{

    private int codigo;
    private String login;
    private String password;
    private String nombre;
    private String direccion;
    private String fonoCasa;
    private String fonoMovil;
    private String sexo;
    private String email;
    private String ciudad;
    private double saldo;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonoCasa() {
        return fonoCasa;
    }

    public void setFonoCasa(String fonoCasa) {
        this.fonoCasa = fonoCasa;
    }

    public String getFonoMovil() {
        return fonoMovil;
    }

    public void setFonoMovil(String fonoMovil) {
        this.fonoMovil = fonoMovil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }



}