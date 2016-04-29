package dsw2.ejbs;

import dsw2.beans.Producto;
import java.util.Vector;
import javax.ejb.Stateful;

@Stateful
public class ProductoBean implements ProductoLocal {
    
      Vector<Producto> vProducto = new Vector<Producto>();

    public java.util.Vector<Producto> agregarProducto(Producto producto) {
        vProducto.add(producto);
        return vProducto;
    }

    public java.util.Vector<Producto> obtenerProductos() {
        return vProducto;
    }

    public boolean hacerPedido() {
        return false;
    }

    public boolean eliminarProducto(int codigo) {
        for(int i=0; i<vProducto.size(); i++){
            int pcod = vProducto.elementAt(i).getCodigo();
            if(pcod==codigo){
                vProducto.remove(i);
                return true;
            }
        }
        return false;
    }

      


}
