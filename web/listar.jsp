<%-- 
    Document   : listar
    Created on : 14-nov-2025, 20:47:20
    Author     : CompuFire
--%>

<%@page import="modelo.Reparacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <title>Listado</title>
</head>
<body>

<h1 align="center">LISTADO DE REPARACIONES</h1>

<center>
    <a href="Controlador?accion=nuevo">
        <button>Agregar Nueva Reparación</button>
    </a>
</div>

    <a href="Controlador?accion=reporte">
        <button>Generar Reporte PDF</button>
    </a>
</center>

<br><br>

<table border="1" width="90%" align="center">
    <tr style="background:#005ab3; color:white;">
        <th>Código</th>
        <th>Cliente</th>
        <th>Modelo</th>
        <th>Servicio</th>
        <th>Costo</th>
        <th>Fecha</th>
        <th>Acciones</th>
    </tr>

    <%
        List<Reparacion> lista = (List<Reparacion>) request.getAttribute("lista");

        if (lista != null) {
        for (Reparacion r : lista) {
    %>

    <tr>
        <td><%= r.getCodigo_servicio() %></td>
        <td><%= r.getNombre_cliente() %></td>
        <td><%= r.getModelo_moto() %></td>
        <td><%= r.getTipo_servicio() %></td>
        <td>Q <%= r.getCosto() %></td>
        <td><%= r.getFecha_ingreso() %></td>
        <td>
        <a href="Controlador?accion=editar&id=<%= r.getCodigo_servicio() %>" 
       style="color: blue; text-decoration:none;">Editar</a> |

        <a href="Controlador?accion=eliminar&id=<%= r.getCodigo_servicio() %>"
       onclick="return confirm('¿Está seguro de eliminar este registro?');"
       style="color: red; text-decoration:none;">Eliminar</a>
        </td>

    </tr>

    <%
            }
        } else {
    %>

    <tr>
        <td colspan="6" style="text-align:center;">No hay datos disponibles.</td>
    </tr>

    <% } %>

</table>

</body>
</html>
