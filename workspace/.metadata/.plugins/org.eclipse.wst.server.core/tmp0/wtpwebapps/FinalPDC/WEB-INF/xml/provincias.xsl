<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="1.0" 
           xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
           xmlns:x="http://www.w3schools.com" >
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Reclamos</title>
                <link rel="stylesheet" type="text/css" href="./css/style.css"/>
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/utils.js"></script>
    <script type="text/javascript" src="./js/main.js"></script>

            </head>
            <body>
                <h3>Reclamos</h3>
                <h5>�Quiere...?</h5>
                <form id="form" name="form">
                <table>
                    <tr>
						<td>�Conoces tu numero de chasis? *</td>
						<td>
		                    <input type="radio" name="sabechasis" value="S" id="isabechasisS" checked="checked" onclick="jFinal.mostrar(this);"/><label for="isabechasisS">Si</label><br/>
							<input type="radio" name="sabechasis" value="N" id="isabechasisN" onclick="jFinal.mostrar(this);"/><label for="isabechasisN">No</label>
		                </td>
                    </tr>
                    
                    <div id="ocultables" name="ocultables">
                    <tr> 
                    	<td >N� de Chasis *</td>
                    	<td><input type="text" id="inrochasis" name="nrochasis" value=""  maxlength="100" size="50" onchange="jFinal.chasis(this);"/></td>
                    	<td><div id="existe" name="existe"></div><div name="noexiste" id="noexiste"></div></td>
                    </tr>
                   	<tr>
                   		<td>Patente</td>
                   		<td><input type="text" id="ipatente" name="patente" value=""  maxlength="100" size="50"/></td>
                   		
                   	</tr>
                   	<tr>
                   		<th>Kilometros</th>
                   		<td><input type="text" id="ikilometros" name="kilometros" value=""  maxlength="100" size="50"/></td>
                   	</tr>
                   	</div>
                    
                   	<tr>
                   		<th>Apellido</th>
                   		<td><input type="text" id="iapellido" name="apellido" value=""  maxlength="100" size="50"/></td>
                   	</tr>
                   	<tr>
                   		<th>Nombre</th>
                   		<td><input type="text" id="inombre" name="nombre" value=""  maxlength="100" size="50"/></td>
                   	</tr>
                   	<tr>
                   		<th>E-Mail</th>
                   		<td><input type="text" id="imail" name="mail" value=""  maxlength="100" size="50"/></td>
                   	</tr>
                   	<tr>
                   		<th>Telefono</th>
                   		<td><input type="text" id="itelefono" name="telefono" value=""  maxlength="100" size="50"/></td>
                   	</tr>
                   	<tr>
						<th >�Desea ser contactado por un vendedor? *</th>
						<td>
		                    <input type="radio" name="vendedor" value="S" id="ivendedorS" checked="checked" /><label for="ivendedorS">Si</label><br/>
							<input type="radio" name="vendedor" value="N" id="ivendedorN" /><label for="ivendedorN">No</label>
		                </td>
                    </tr>
                    <tr>
                    	<th>Provincia</th>
                    	<td>
	                    <select id="provincia" name="provincia">
		                    <xsl:for-each select="x:provincias/x:provincia">
		                        <xsl:element name="option">
		                        	<xsl:attribute name="value">
		                        	<xsl:value-of select="@cod_provincia"></xsl:value-of>
		                     		
		                        	</xsl:attribute>
		                        	<xsl:value-of select="."></xsl:value-of>
		                        </xsl:element>
		                    </xsl:for-each>
		                    </select>
	                    </td>
                    </tr>
                    <tr><th>Reclamo(4000 caracteres max.) *</th></tr>
                    <tr><td colspan="2"><textarea cols="100" rows="5" id="ireclamos" name="reclamos"  onkeyup=""></textarea></td></tr>
                </table>   
                </form>
                <input type="button" onclick="jFinal.registrar();">Registrar</input>
                   
                <br/><br/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
