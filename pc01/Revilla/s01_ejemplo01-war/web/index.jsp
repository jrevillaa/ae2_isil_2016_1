<%@page import="javafx.scene.input.KeyCode.T"%>

<%@page import="javax.ejb.EJB"%>
<%@page import="ae2.ejbs.ClientesBeanLocal"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    

ClientesBeanLocal cli;

    List lista = cli.listarClientes();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido!</h1>
         <h1>Lista de Productos!</h1>
         <a href="productoInsertar.jsp">Nuevo Cliente</a>
         <br/>
         <table border="1" cellspacing="1" cellpadding="1">
             <thead>
                 <tr>
                     <th>Codigo</th>
                     <th>Descripción</th>
                     <th>Precio</th>
                     <th>Stock Actual</th>
                     <th>Stock Minimo</th>
                     <th>Linea</th>
                     <th>Importado</th>
                 </tr>
             </thead>
             <tbody>
                 <% for(Producto curso: lista){  %>
                 <tr>
                     <td><%=curso.getCodpro()%></td>
                     <td><%=curso.getDespro()%></td>
                     <td><%=curso.getPrepro()%></td>
                     <td><%=curso.getStkact()%></td>
                     <td><%=curso.getStkmin()%></td>
                     <td><%=curso.getLinpro()%></td>
                     <td><%=curso.getImportado()%></td>
                     <td><a href="productoEliminar.jsp?codigo=<%=curso.getCodpro() %>">Eliminar</a></td>
                     <td><a href="productoActualizar.jsp?codigo=<%=curso.getCodpro() %>">Actualizar</a></td>
                 </tr>
                 <%}%>
             </tbody>
         </table>

         
        
    </body>
</html>