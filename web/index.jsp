<%-- 
    Document   : index
    Created on : 14-nov-2025, 21:23:56
    Author     : CompuFire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Moto Reparaciones Calel</title>
    <style>
        body { 
            font-family: Arial; 
            text-align: center; 
            background: #f0f4ff;
        }
        .menu a {
            display: inline-block;
            padding: 12px 20px;
            margin: 10px;
            background: #005ab3;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        img {
            width: 150px;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h1>MOTO REPARACIONES CALEL</h1>
<img src="imagenes/logo.png">

<p><b>Dirección:</b> Zona 3, Ciudad de Guatemala</p>
<p><b>Teléfono:</b> 5511-2290</p>

<div class="menu">
    <a href="Controlador?accion=listar">Listar Servicios</a>
    <a href="Controlador?accion=nuevo">Nuevo Servicio</a>
</div>

</body>
</html>
    
