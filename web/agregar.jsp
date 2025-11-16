<%-- 
    Document   : formAgregar
    Created on : 14-nov-2025, 21:26:00
    Author     : CompuFire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Reparación</title>
</head>
<body>

<h2 align="center">AGREGAR NUEVA REPARACIÓN</h2>

<form action="Controlador" method="post" style="width:400px; margin:auto;">
    <input type="hidden" name="accion" value="insertar">

    Cliente:<br>
    <input type="text" name="nombre" required><br><br>

    Modelo:<br>
    <input type="text" name="modelo" required><br><br>

    Tipo Servicio:<br>
    <input type="text" name="tipo" required><br><br>

    Costo:<br>
    <input type="number" step="0.01" name="costo" required><br><br>

    Fecha ingreso:<br>
    <input type="date" name="fecha" required><br><br>

    <button type="submit">Guardar</button>
</form>

<br>
<center><a href="Controlador?accion=listar">Regresar</a></center>

</body>
</html>
