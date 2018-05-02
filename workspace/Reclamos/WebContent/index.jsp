<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   	<script type="text/javascript" src="./js/jquery.js"></script>
   	<script type="text/javascript" src="./js/utils.js"></script>
   	<script type="text/javascript" src="./js/JReclamos.js"></script>
<title>Reclamos</title>
</head>
<body>
	<form id="form" action="javascript:void(null)" method="post">
		<div id="mensaje"></div>
		<div id="divreclamo">
		<h1>Reclamos</h1>
		<h3>Quiere hacer un reclamo?</h3>

		    <table>
                <tr>
                    <th width="20%" align="right"><label for="iconoce">Conoce su numero de chasis?*</label></th>
                    <td>
                        <input type="radio" name="conoce" value="Si" id="iconoceS" checked="checked" /><label for="iconoceS">Si</label>
						<input type="radio" name="conoce" value="No" id="iconoceN" /><label for="iconoceN">No</label>
                    </td>
                </tr>
    			<tr>
                    <th width="20%" align="right"><label for="ichasis">N de chasis:</label></th>
                    <td><input type="text" id="ichasis" name="chasis" value="" maxlength="255" size="50"/></td>
                    <td align="left"><div id="divchasis"></div></td>
				</tr>
    			<tr>
                    <th width="20%" align="right"><label for="ipatente">Patente:</label></th>
                    <td><input type="text" id="ipatente" name="patente" value="" maxlength="255" size="50"/></td>
				</tr>
    			<tr>
                    <th width="20%" align="right"><label for="ikm">Kilometros</label></th>
                    <td><input type="text" id="ikm" name="km" value="" maxlength="255" size="50"/></td>
				</tr>
				<tr>
                    <th width="20%" align="right"><label for="iapellido">Apellido:*</label></th>
                    <td><input type="text" id="iapellido" name="apellido" value="" maxlength="255" size="50"/></td>
				</tr>
				<tr>
                    <th width="20%" align="right"><label for="inombre">Nombre:*</label></th>
                    <td><input type="text" id="inombre" name="nombre" value="" maxlength="255" size="50"/></td>
				</tr>
				<tr>
                    <th width="20%" align="right"><label for="iemail">E-mail*</label></th>
                    <td><input type="text" id="iemail" name="email" value="" maxlength="255" size="50"/></td>
				</tr>
				<tr>
                    <th width="20%" align="right"><label for="itelefono">Telefono:</label></th>
                    <td><input type="text" id="itelefono" name="telefono" value="" maxlength="255" size="50"/></td>
				</tr>
				<tr>
                    <th width="20%" align="right"><label for="icontacto">Desea ser contactado por un vendedor?*</label></th>
                    <td>
                        <input type="radio" name="contacto" value="S" id="icontactoS" checked="checked" /><label for="icontactoS">Si</label>
						<input type="radio" name="contacto" value="N" id="icontactoN" /><label for="icontactoN">No</label>
                    </td>
                </tr>
				<tr>
                    <th width="20%" align="right" valign="top"><label for="ireclamo">Reclamo(4000 caracteres max)*:</label></th>
                    <td>
                        <textarea cols="38" rows="5" id="ireclamo" name="reclamo"  onkeyup="return jForm.validActLen(this)"></textarea><!-- cuando levanta la tecla -->
                    </td>
				</tr>
				<tfoot>
					<tr>
						<td></td>
						<td align="left"><input type="button" name="registrar" value="Registrar" onclick="jReclamosf.registrar()"></td>
					</tr>
				</tfoot>
            </table>

	</form>
	</div>
</body>
</html>