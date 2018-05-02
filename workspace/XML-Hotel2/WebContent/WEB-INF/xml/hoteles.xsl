<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
           xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
           xmlns:x="http://www.w3schools.com" >
    <xsl:output method="html"/>
    <xsl:param name="titulo" />
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejemplo XSLT</title>
                <link rel="stylesheet" type="text/css" href="./css/style.css"/>
            </head>
            <body>
                <h3><xsl:value-of select="$titulo"/></h3>
                <select name="provincias">
                	<option value="-1">Seleccione una provincia</option>
                	<xsl:for-each select="x:hoteles_config/x:provincias/x:provincia">
                            <option>
                            	<xsl:attribute name="value">
                                  	<xsl:value-of select="@codigo"/>
                            	</xsl:attribute>
                            	<xsl:value-of select="text()"/>
                            </option>
                                                        
                    </xsl:for-each>
                </select>
                
                <br/><br/>
                <select name="tipos_habitaciones">
                	<!--  <option value="D">Seleccione el tipo de habitacion</option>-->
                	<xsl:for-each select="x:hoteles_config/x:tipos_habitaciones/x:tipo">
                            <option>
                            	<xsl:attribute name="value">
                                  	<xsl:value-of select="@codigo"/>
                            	</xsl:attribute>
                            	<xsl:value-of select="text()"/>
                            </option>
                                                        
                    </xsl:for-each>
                </select>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>