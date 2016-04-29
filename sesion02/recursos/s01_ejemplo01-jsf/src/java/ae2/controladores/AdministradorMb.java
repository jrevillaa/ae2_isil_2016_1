package ae2.controladores;

import ae2.ejbs.AdministradorBeanLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AdministradorMb {
    
    private String user;
    private String pass;
    private String mensaje;

    @EJB
    AdministradorBeanLocal abl;
    public void validar(){
        mensaje= abl.validarLocal(user, pass);
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
