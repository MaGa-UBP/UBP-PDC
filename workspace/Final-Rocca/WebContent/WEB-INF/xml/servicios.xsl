<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="1.0" 
           xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
           xmlns:x="http://www.w3schools.com" >
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Carga de sugerencias</title>
                <link rel="stylesheet" type="text/css" href="./css/style.css"/>
                <script type="text/javascript" src="./js/jquery.js"></script>
				<script type="text/javascript" src="./js/utils.js"></script>
				<script type="text/javascript" src="./js/script.js"></script>
            </head>
            <body>
            	<div id="contenido">
	                <h2 class="titulo">Nueva sugerencia</h2>
	                
					<label>¿Desea identificarse? </label>
					<input type="radio" name="identificacion" value="Si" checked="checked" onclick="jFormulario.showEmail()">Si</input>
					<input type="radio" name="identificacion" value="No" onclick="jFormulario.hideEmail()">No</input>
					<br></br>
					<div id="dEmail">
						<label name="lEmail">E-Mail: </label>
						<br/>
						<input type="text" id="iEmail" name="nEmail" value=""></input>
					</div>				
					<label>Servicio</label><br></br>
					<select id="serviciosSelect" onchange="jFormulario.traerTemas(this)"> 
						<option selected="selected" >Debe seleccionar un servicio</option>
						<xsl:for-each select="x:servicios/x:servicio">
	                            <xsl:element name="option">
	                            	<xsl:attribute name="value">
	                            		<xsl:value-of select="@codigo" />
	                            	</xsl:attribute>
	                            	<xsl:value-of select="." />
	                            </xsl:element>
	                    </xsl:for-each>
					</select>
					<br/>
					<div id="temas"></div>
					<textarea id="comentario" rows="4" cols="50"></textarea>
					<br/>
					<input type="button" value="Guardar" onclick="jFormulario.guardar()"></input>
					<input type="button" value="Cancelar" onclick="jFormulario.cancelar()"></input>
				</div>
				<div id="error"></div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
