<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Ejemplo 3</title>
                <link rel="stylesheet" type="text/css" href="./css/style.css"/>
            </head>
            <body>
		    	<h1>
		       		<xsl:value-of select="/rss/channel/title" />
		        </h1>
		        <ul>
		        <xsl:for-each select="/rss/channel/item">
		             <li>
		                 <a target="_blank">
		                     <xsl:attribute name="href">
		                         <xsl:value-of select="./link"/>
		                     </xsl:attribute>
		                     <xsl:value-of select="./title" />
		                 </a>
		             </li>
		        </xsl:for-each>
		        </ul>
		        <br/>
		        <a href="index.jsp" target="_self">Volver al index principal</a>
		   </body>
	  	</html>
	</xsl:template>
</xsl:stylesheet>
