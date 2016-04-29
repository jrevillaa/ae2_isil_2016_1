<%@page import = "java.util.Vector" %>
<%@page import = "dsw2.beans.Producto" %>
<%
        Vector<Producto> v = ( Vector<Producto>)request.getSession().getAttribute("lista");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi Carrito de compras</title>
    </head>
    <body>
        
        <h1>Ingresa producto</h1>
    <form name="frmX" action="sCarrito">
        Codigo <input type="text" name="txtCodigo" value="" /><br>
        Nombre<input type="text" name="txtNombre" value="" /><br>
        Precio<input type="text" name="txtPrecio" value="" /><br>
        Stock<input type="text" name="txtStock" value="" /><br>
        <input type="submit" value="Agregar al Carrito" />
    </form>
    <h1>Lista de Productos</h1>
        <table border="1">
            <tr>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Stock</th>
            </tr>
            <%for(int i =0; i<v.size(); i++){ %>
            <tr>
                <td><%=v.elementAt(i).getCodigo() %></td>
                <td><%=v.elementAt(i).getNombre() %></td>
                <td><%=v.elementAt(i).getPrecio() %></td>
                <td><%=v.elementAt(i).getStock() %></td>
            </tr>
            <%}%>
        </table>

    </body>
</html>
