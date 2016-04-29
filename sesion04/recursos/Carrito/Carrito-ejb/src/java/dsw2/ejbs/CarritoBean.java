package dsw2.ejbs;

import dsw2.beans.Elemento;
import dsw2.daos.OrdenDAO;
import java.util.Vector;
import javax.ejb.Stateful;

@Stateful
public class CarritoBean implements CarritoLocal {
    Vector<Elemento> carrito = new Vector<Elemento>();
    //metodo de negocio para agregar elementos al carrito
    @Override
    public Vector<Elemento> agregarItem(Elemento elemento) {
        carrito.add(elemento);
        return carrito;
    }
    //eliminar elementos del carrito
    public boolean eliminarItem(int codigo) {
        for(int i=0; i< carrito.size(); i++) {
            if(carrito.elementAt(i).getCodigo()==codigo){
                carrito.removeElementAt(i);
                return true;
            }
        }
        return false;
    }
   //obtener elementos del carrito como Vector
    public Vector<Elemento> obtenerItems() {
        return carrito;
    }

    public boolean realizarPedido(int cli_codigo) {
        //***************Pasos para generar orden****************
        //calculo del monto total
        double mt = calcularMontoTotal();
        boolean flag = new OrdenDAO().generarOrden(cli_codigo,mt,carrito);
        //eliminar todos los elementos del carrito.
        carrito.removeAllElements();
        return flag;
    }

    private double calcularMontoTotal() {
        double mt =0;
        for(int j =0; j<carrito.size(); j++) mt+=carrito.elementAt(j).getMonto();
        return mt;
    }
    

       
}
