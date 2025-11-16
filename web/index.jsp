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
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .contenedor {
            width: 80%;
            margin: auto;
            text-align: center;
            margin-top: 50px;
            background: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }

        h1 {
            color: #003a75;
            margin-bottom: 10px;
        }

        h3 {
            color: #444;
            margin-top: -10px;
        }

        img {
            width: 150px;
            margin-top: 20px;
            width: 160px;
            height: auto;
        }

        .info {
            margin: 20px 0;
            font-size: 18px;
        }

        .botones {
            margin-top: 30px;
        }

        .btn {
            background: #005ab3;
            color: white;
            padding: 12px 25px;
            border: none;
            margin: 10px;
            font-size: 16px;
            border-radius: 8px;
            cursor: pointer;
            transition: 0.3s;
        }

        .btn:hover {
            background: #003f80;
        }
    </style>
</head>

<body>

<div class="contenedor">

    <img src="imagenes/logo.png" alt="Logo del Taller">

    <h1>MOTO REPARACIONES CALEL</h1>
    <h3>“Servicio rápido, honesto y profesional”</h3>

    <div class="info">
        <p><strong>Dirección:</strong> Zona 1, Ciudad de Guatemala</p>
        <p><strong>Teléfono:</strong> +502 4568-7780</p>
        <p><strong>Correo:</strong> motocalel@gmail.com</p>
    </div>

    <hr style="margin: 30px 0;">

    <div class="botones">
        <a href="Controlador?accion=listar">
            <button class="btn">Ver Reparaciones</button>
        </a>

        <a href="Controlador?accion=nuevo">
            <button class="btn">Agregar Reparación</button>
        </a>

        <a href="Controlador?accion=reporte">
            <button class="btn">Generar Reporte PDF</button>
        </a>
    </div>

</div>

</body>
</html>
    
