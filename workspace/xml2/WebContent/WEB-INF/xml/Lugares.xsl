<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="1.0" 
           xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
           xmlns:x="http://www.w3schools.com" >
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Vuelos</title>
                <link rel="stylesheet" type="text/css" href="./css/style.css"/>
                <script type="text/javascript" src="./js/jquery.js"></script>
                <script type="text/javascript" src="./js/utils.js"></script>
                <script type="text/javascript" src="./js/main.js"></script>
            </head>
            <body>
                <h3>Reservas</h3>
                <table>
                    <colgroup>
                        <col width="100px"/>
                        <col width="400px"/>
                    </colgroup>
                    <thead>
                         <tr>
                             <td>Criterio de búsqueda</td>
                         </tr>
                    </thead>
                    <tbody>
                    <tr>
                    	<td align="right">Origen:</td>
	                    <td>
		                    <select name="origen">
			                    <xsl:for-each select="x:lugares/x:origenes/x:origen">
			                            <option>
			                            <xsl:attribute name="value">
      										<xsl:value-of select="x:codigo" />
   										</xsl:attribute>
			                            	<xsl:value-of select="x:nombre"/>
			                            </option>
			                    </xsl:for-each>
		                    </select>
	                    </td>
                    </tr>
                    <tr>
                    	<td align="right">Destino:</td>
	                    <td>
		                    <select name="destino">
			                    <xsl:for-each select="x:lugares/x:destinos/x:destino">
			                            <option>
			                            <xsl:attribute name="value">
      										<xsl:value-of select="x:codigo" />
   										</xsl:attribute>
			                            	<xsl:value-of select="x:nombre"/>
			                            </option>
			                    </xsl:for-each>
		                    </select>
	                    </td>
                    </tr>
                    <tr>
                    	<td align="right">Pasajeros:</td>
	                    <td>
		                    <input type="text" name="cantPasajeros" value="1"/>
	                    </td>
                    </tr>
                    <tr>
                    	<td align="right">Desde:</td>
	                    <td>
		                    <input type="text" name="fechaDesde" value="01/01/2014"/>
		                    Ej: 14/10/2014
	                    </td>
                    </tr> 
                    <tr>
                    	<td align="right">Hasta:</td>
	                    <td>
		                    <input type="text" name="fechaHasta" value="07/11/2014"/>
		                    Ej: 07/11/2014
	                    </td>
                    </tr> 
                    <tr>
                    	<td align="right">
                    		<input type="button" value="Buscar" onClick="jVuelos.buscar()"/>
                    	</td>
                    </tr> 
                    </tbody>
                </table>
                <br/><br/>
                <table>
                	<colgroup>
	                        <col width="100px"/>
	                        <col width="100px"/>
	                        <col width="100px"/>
                        	<col width="100px"/>
                    </colgroup>
                	<thead>
                         <tr>
                             <td>Fecha Vuelo</td>
                             <td>Asientos Libres</td>
                             <td>Pasajeros</td>
                             <td> </td>
                         </tr>
                    </thead>  
                    <tbody>
                    	<tr>
	                    	<td>
	                    		09/06/2015
	                    	</td>
	                    	<td>
	                    		10
	                    	</td>
	                    	<td>
	                    		<input type="text" name="" value=""/>
	                    	</td>
	                    	<td>
	                    		<a href="#">reservar</a>
	                    	</td>
                    	</tr> 
                    </tbody>            
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
