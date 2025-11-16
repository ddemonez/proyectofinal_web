<%-- 
    Document   : editar
    Created on : 15-nov-2025, 0:03:46
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
</head>
<body>

<h2 align="center">EDITAR REPARACIÓN</h2>

<form action="Controlador" method="post" style="width:400px; margin:auto;">
    <input type="hidden" name="accion" value="actualizar">
    <input type="hidden" name="codigo" value="<%= r.getCodigo_servicio() %>">

    Cliente:<br>
    <input type="text" name="nombre" value="<%= r.getNombre_cliente() %>" required><br><br>

    Modelo Moto:<br>
    <input type="text" name="modelo" value="<%= r.getModelo_moto() %>" required><br><br>

    Tipo Servicio:<br>
    <input type="text" name="tipo" value="<%= r.getTipo_servicio() %>" required><br><br>

    Costo:<br>
    <input type="number" step="0.01" name="costo" value="<%= r.getCosto() %>" required><br><br>

    Fecha ingreso:<br>
    <input type="date" name="fecha" value="<%= r.getFecha_ingreso() %>" required><br><br>

    <button type="submit">Actualizar</button>
</form>

<br>
<center><a href="Controlador?accion=listar">Regresar</a></center>

</body>
</html>
