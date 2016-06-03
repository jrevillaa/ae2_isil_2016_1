/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.fachadas;

import ae2.entidades.TbProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumno-CT
 */
@Local
public interface TbProductoFacadeLocal {

    void create(TbProducto tbProducto);

    void edit(TbProducto tbProducto);

    void remove(TbProducto tbProducto);

    TbProducto find(Object id);

    List<TbProducto> findAll();

    List<TbProducto> findRange(int[] range);

    int count();

    List<TbProducto> prodPerRange(int min, int max);

    List<TbProducto> findAllOrder();

    List<TbProducto> findByName(String name);
    
}
