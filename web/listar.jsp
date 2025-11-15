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
    <title>Listado de Reparaciones</title>
    <style>
        table {
            width: 90%;
            border-collapse: collapse;
            margin: 20px auto;
            font-family: Arial;
        }
        th {
            background-color: #005ab3;
            color: white;
            padding: 8px;
        }
        td {
            border: 1px solid #ccc;
            padding: 6px;
        }
        h2 {
            text-align: center;
            font-family: Arial;
        }
    </style>
</head>
<body>

<h2>LISTADO DE REPARACIONES</h2>
<div style="text-align:center; margin-bottom: 20px;">
    <a href="Controlador?accion=pdf" 
       style="padding:10px 20px; background:#005ab3; color:white; text-decoration:none; border-radius:5px;">
       Generar Reporte PDF
    </a>
</div>


<table>
    <tr>
        <th>Código</th>
        <th>Cliente</th>
        <th>Modelo Moto</th>
        <th>Tipo Servicio</th>
        <th>Costo</th>
        <th>Fecha Ingreso</th>
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
