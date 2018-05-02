<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Ejemplo 5</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/ejemplo45.js"></script>
</head>
<body>
    <h3>Formulario de carga de datos</h3>
	<%
	if(request.getParameterMap().size() == 0) {
	%>
    <form id="form" action="ejemplo5.jsp" method="post">
        <table>
        	<colgroup>
        		<col width="20%" />
        		<col width="45%" />
        	</colgroup>
            <tr>
                <th align="right"><label for="iapellido">Apellido:</label></th>
                <td>
                    <input type="text" id="iapellido" name="apellido" value="" maxlength="100" size="50"/>
                </td>
            </tr>
			<tr>
                <th align="right"><label for="inombre">Nombre:</label></th>
                <td><input type="text" id="inombre" name="nombre" value="" maxlength="255" size="50"/></td>
			</tr>
			<tr>
                <th align="right"><label for="iclave">Ingrese Clave:</label></th>
                <td><input type="password" id="iclave" name="clave" value="" maxlength="32" size="50"/></td>
			</tr>
			<tr>
                <th align="right"><label for="iconfirmar_clave">Repetir Clave:</label></th>
                <td><input type="password" id="iconfirmar_clave" name="confirmar_clave" value="" maxlength="32" size="50"/></td>
			</tr>
			<tr>
                <th align="right" valign="top"><label for="isexoF">Sexo:</label></th>
                <td>
                    <input type="radio" name="sexo" value="F" id="isexoF" checked="checked" /><label for="isexoF">Femenino</label><br/>
					<input type="radio" name="sexo" value="M" id="isexoM" /><label for="isexoM">Masculino</label>
                </td>
			</tr>
			<tr>
                <th align="right" valign="top"><label for="inacionalidad">Nacionalidad:</label></th>
                <td>
                	<nobr>
					<select id="inacionalidad" name="nacionalidad" onchange="jForm.selNacionalidad(this)">
						<option value="">Debe seleccionar una nacionalidad</option>
						<option value="AR" selected="selected">Argentina</option>
						<option value="BO">Boliviana</option>
						<option value="BR">Brasile&ntilde;a</option>
						<option value="CH">Chilena</option>
						<option value="PY">Paraguaya</option>
						<option value="UY">Uruguaya</option>
						<option value="-1">Otra</option>
					</select>&nbsp;&nbsp;
					<input type="text" id="iotranac" name="otra_nacionalidad" maxlength="255" size="40" disabled="disabled"/>
					</nobr>
				</td>
			</tr>
			<tr>
                <th align="right" valign="top"><label for="iequipo">Equipo Favorito:</label></th>
                <td>
                    <select id="iequipo" name="equipo" size="5" multiple>
                        <option value="BE">Belgrano</option>
                        <option value="BC">Boca</option>
                        <option value="L">Lan&uacute;s</option>
                        <option value="RA">Racing</option>
                        <option value="RV">River</option>
                        <option value="SL">San Lorenzo</option>
                    </select>
                </td>
			</tr>
			<tr>
                <th align="right" valign="top">Hobbies:</th>
                <td>
                    <input type="checkbox" name="hobbies" value="Bailar" id="bailar" /><label for="bailar">Bailar</label><br/>
                    <input type="checkbox" name="hobbies" value="Cantar" id="cantar" /><label for="cantar">Cantar</label><br/>
                    <input type="checkbox" name="hobbies" value="Deportes" id="deportes" /><label for="deportes">Deportes</label><br/>
                    <input type="checkbox" name="hobbies" value="Leer" id="leer" /><label for="leer">Leer</label><br/>
                </td>
			</tr>
			<tr>
                <th align="right" valign="top"><label for="iactividades">Otras Actividades:</label></th>
                <td>
                    <textarea cols="50" rows="5" id="iactividades" name="actividades" onkeyup="return jForm.validActLen(this)"></textarea>
                    <h5><span id="icact"></span> caracteres</h5>
                    <script type="text/javascript">
                    jForm.setActLen();
                    </script>
                </td>
			</tr>
        </table>
        <br/>
        <fieldset>
            <input type="button" name="boton1" value="Mostrar Datos" onclick="jForm.valid()" />
            <input type="reset"  name="boton2" value="Limpiar formulario"/>
        </fieldset>
    </form>
    <br/>
    <a href="./index.html">Volver al index principal</a>
	<%
	}
	else {		
		HashMap<String,String> nacionalidades = new HashMap<String,String>();
		HashMap<String,String> equipos        = new HashMap<String,String>();

		nacionalidades.put("AR", "Argentina");
	    nacionalidades.put("BO", "Boliviana");
	    nacionalidades.put("BR", "Brasileña");
	    nacionalidades.put("CH", "Chilena");
	    nacionalidades.put("PY", "Paraguaya");
	    nacionalidades.put("UY", "Uruguaya");
	    
	    equipos.put("BE", "Belgrano");
	    equipos.put("BC", "Boca");
	    equipos.put("L", "Lanús");
	    equipos.put("RA", "Racing");
	    equipos.put("RV", "River");
	    equipos.put("SL", "San Lorenzo");
	%>
    <table>
       	<colgroup>
       		<col width="20%" />
       		<col width="45%" />
       	</colgroup>
    	<tr>
             <th align="right">Apellido:</th>
             <td><%= request.getParameter("apellido") %></td>
        </tr>
		<tr>
             <th align="right">Nombre:</th>
             <td><%= request.getParameter("nombre") %></td>
		</tr>
		<tr>
             <th align="right">Clave:</th>
             <td><%= request.getParameter("clave") %></td>
		</tr>
		<tr>
             <th align="right">Confirmaci&oacute;n Clave:</th>
             <td><%= request.getParameter("confirmar_clave") %></td>
		</tr>
		<tr>
             <th align="right">Sexo:</th>
             <td><%= (request.getParameter("sexo").equals("F") ? "Femenino" : "Masculino") %></td>
		</tr>
		<tr>
             <th align="right">Nacionalidad:</th>
             <td><%= (request.getParameter("otra_nacionalidad") == null || request.getParameter("otra_nacionalidad").equals("") ? nacionalidades.get(request.getParameter("nacionalidad")) : request.getParameter("otra_nacionalidad")) %></td>
		</tr>
		<tr>
             <th align="right" valign="top">Equipo Favorito:</th>
             <td>
             <% 
             if(request.getParameterValues("equipo") != null) {
	             String eq[] = request.getParameterValues("equipo");
	             for(int i = 0, l = eq.length; i < l; i ++) {
	            	 out.println(equipos.get(eq[i]) + "; ");
	             }
             }
             else {
            	 out.println("Ninguno");
             }
             %>
             </td>
		</tr>
		<tr>
            <th align="right" valign="top">Hobbies:</th>
            <td>
            <% 
            String h[] = request.getParameterValues("hobbies");
            for(int i = 0, l = h.length; i < l; i ++) {
           	 	out.println(h[i] + "; ");
            }
            %>
            </td>
		</tr>
		<tr>
            <th align="right" valign="top">Otras Actividades:</th>
            <td><%= request.getParameter("actividades") %></td>
		</tr>
	</table>
	<br/>
	<a href="./ejemplo5.jsp">Volver</a>
	<%
	}
	%>
</body>
</html>