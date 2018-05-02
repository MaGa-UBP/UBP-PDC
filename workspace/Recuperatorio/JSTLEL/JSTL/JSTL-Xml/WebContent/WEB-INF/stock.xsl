<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejemplo 4</title>
                <link rel="stylesheet" type="text/css" href="./css/style.css"/>
            </head>
            <body>
                <h1>Productos faltantes</h1>
                <table class="tabla">
                    <thead>
                         <tr>
                             <td align="right">Id.</td>
                             <td>Nombre</td>
                         </tr>
                    </thead>
                    <tbody>
                    <xsl:for-each select="/productos/producto">
                        <xsl:if test="./cant = 0">
                            <tr>
                                <td align="right"><xsl:value-of select="./id"/></td>
                                <td><xsl:value-of select="./nom"/></td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                    </tbody>
                </table>      
                <br/>
                <a href="index.jsp" target="_self">Volver al index principal</a>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
