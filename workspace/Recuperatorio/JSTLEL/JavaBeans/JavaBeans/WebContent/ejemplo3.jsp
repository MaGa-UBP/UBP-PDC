<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ejemplo 3</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
    <h2>Formulario de Carga</h2>
    <form action="ejemplo3-res.jsp" method="post">
        <table>
            <thead>
                <tr>
                    <td colspan="4">Datos Personales</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th align="right">Apellido:</th>
                    <td colspan="3"><input type="text" name="apellido" value="" maxlength="40" size="60"/></td>
                </tr>
                <tr>
                    <th align="right">Nombre:</th>
                    <td colspan="3"><input type="text" name="nombre" value="" maxlength="40" size="60"/></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="4" align="right"><input type="submit" name="boton" value="Mostrar Datos Ingresados"/></td>
                </tr>
            </tfoot>
        </table>            
    </form>        
    <br/>
    <a href="index.jsp" target="_self">Volver al index principal</a>
</body>
</html>
