package ae2.controladores;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ae2.ejbs.ClientesBeanLocal;

@ManagedBean
@SessionScoped
public class AdministradorMb {
    
    private String user;
    private String pass;
    private String mensaje;

    @EJB
    ClientesBeanLocal abl;
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
