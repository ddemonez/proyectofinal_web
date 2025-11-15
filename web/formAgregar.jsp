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
    <style>
        form { width: 40%; margin: auto; background: #e8f0ff; padding: 20px; border-radius: 10px; }
        input { width: 100%; padding: 8px; margin-top: 8px; }
        button { padding: 10px 20px; background: #005ab3; color: white; border: none; }
    </style>
</head>
<body>

<h2 style="text-align:center;">Agregar Nuevo Servicio</h2>

<form action="Controlador" method="post">
    <input type="hidden" name="accion" value="agregar">

    Nombre del cliente:
    <input type="text" name="nombre">

    Modelo de moto:
    <input type="text" name="modelo">

    Tipo de servicio:
    <input type="text" name="tipo">

    Costo:
    <input type="number" step="0.01" name="costo">

    Fecha ingreso (AAAA-MM-DD):
    <input type="text" name="fecha">

    <br><br>
    <button type="submit">Guardar</button>
</form>

</body>
</html>
