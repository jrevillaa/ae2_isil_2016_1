<%@page import="dsw2.beans.Producto" %>
<%@page import="dsw2.beans.Cliente" %>
<%@page import="dsw2.beans.Elemento" %>
<%@page import="java.util.Vector" %>


<%

       Vector<Producto> listap = (Vector<Producto>)request.getSession().getAttribute("listaproductos");
       Cliente cliente = (Cliente)request.getSession().getAttribute("scliente");
       Vector<Elemento> micarrito = (Vector<Elemento>)request.getSession().getAttribute("carrito");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenidos a la tienda virtual</title>
    </head>
    <body>
        <h1> Seleccione producto a comprar Sr.(a) <%=cliente.getNombre()%> </h1>

    listado de productos, mostrando el stock con cajas para ingresar cantidad a pedir

        <table border="0">
            <tr>
                <td><!-- lista de productos -->
                  <table border>
                            <tr>
                                <th>codigo</th>
                                <th>descripcion</th>
                                <th>precio</th>
                                <th>stock</th>
                                <th>cantidad</th>
                                <th>Accion</th>
                            </tr>
                              <%
                              for(int i=0; i<listap.size(); i++){
                            %>
                            <form name="frmCarrito" action="sCarrito">
                                 <tr>
                                     <td>
                                         <%=listap.elementAt(i).getCodigo() %>
                                         <input type="hidden" name="txtCodProducto" value="<%=listap.elementAt(i).getCodigo() %>" />
                                     </td>
                                     <td><%=listap.elementAt(i).getDescripcion() %></td>
                                     <td><%=listap.elementAt(i).getPrecio() %></td>
                                     <td><%=listap.elementAt(i).getStock() %></td>
                                     <td><input type="text" name="txtCantidad" value="0" /></td>
                                     <td><input type="submit" value="Agregar" name="accion" /></td>
                                 </tr>
                            </form>
                            <%}%>
                        </table>
                </td>
                <td><!-- elementos del carrito -->
                      <form action="sCarrito">
                            <table border="3">
                                <tr>
                                    <th>codigo</th>
                                    <th>descripcion</th>
                                    <th>cantidad</th>
                                    <th>monto</th>
                                    <th>Seleccione</th>
                                </tr>
                                <% for(int j=0; j<micarrito.size(); j++){  %>
                                <tr>
                                    <td><%=micarrito.elementAt(j).getCodigo() %></td>
                                    <td><%=micarrito.elementAt(j).getDescripcion() %></td>
                                    <td><%=micarrito.elementAt(j).getCantidad() %></td>
                                    <td><%=micarrito.elementAt(j).getMonto() %></td>
                                    <td>
                                        <input type="radio" name="rbtCodigo" value="<%=micarrito.elementAt(j).getCodigo() %>" />
                                    </td>
                                </tr>
                                <%}%>
                            </table>
                            <input type="submit" value="Ordenar" name="accion" />
                            <input type="submit" value="Eliminar" name="accion" />
                            </form>
                </td>
            </tr>
        </table>

      

      

    </body>
</html>
