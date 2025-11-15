<%-- 
    Document   : formEditar
    Created on : 14-nov-2025, 21:26:31
    Author     : CompuFire
--%>

<%@page import="modelo.Reparacion"%>
<%
    Reparacion r = (Reparacion) request.getAttribute("dato");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Reparación</title>
    <style>
        form { width: 40%; margin: auto; background: #fce4ec; padding: 20px; border-radius: 10px; }
        input { width: 100%; padding: 8px; margin-top: 8px; }
        button { padding: 10px 20px; background: #e91e63; color: white; border: none; }
    </style>
</head>
<body>

<h2 style="text-align:center;">Editar Servicio</h2>

<form action="Controlador" method="post">
    <input type="hidden" name="accion" value="actualizar">

    Código:
    <input type="text" name="codigo" value="<%= r.getCodigo_servicio() %>" readonly>

    Nombre del cliente:
    <input type="text" name="nombre" value="<%= r.getNombre_cliente() %>">

    Modelo de moto:
    <input type="text" name="modelo" value="<%= r.getModelo_moto() %>">

    Tipo de servicio:
    <input type="text" name="tipo" value="<%= r.getTipo_servicio() %>">

    Costo:
    <input type="number" step="0.01" name="costo" value="<%= r.getCosto() %>">

    Fecha ingreso:
    <input type="text" name="fecha" value="<%= r.getFecha_ingreso() %>">

    <br><br>
    <button type="submit">Actualizar</button>
</form>

</body>
</html>
