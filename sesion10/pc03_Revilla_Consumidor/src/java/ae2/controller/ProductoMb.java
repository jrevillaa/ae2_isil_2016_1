/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.controller;

import ae2.ws.MiServicio;
import ae2.ws.MiServicio_Service;
import ae2.ws.TbProducto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Alumno-CT
 */
@ManagedBean
@SessionScoped
public class ProductoMb {

    private String name;
    private List<TbProducto> lstno;
    
    public ProductoMb() {
    }
    
    public List<TbProducto> listar(){
        List<TbProducto> lst = new ArrayList<>();
        MiServicio_Service servicio = new MiServicio_Service();
        MiServicio port = servicio.getMiServicioPort();
        lst = port.findAllOrder();
        
        return lst;
    }
    
    public void buscar(){
        List<TbProducto> lst = new ArrayList<>();
        MiServicio_Service servicio = new MiServicio_Service();
        MiServicio port = servicio.getMiServicioPort();
        lstno = port.findByName(name);
    }
    
    public List<TbProducto> print(){
        return lstno;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public List<TbProducto> getLstNo() {
        return lstno;
    }

    public void setLstNo(List<TbProducto> lstno) {
        this.lstno = lstno;
    }
    
}
