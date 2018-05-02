<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <meta charset="ISO-8859-1">
        <title>Cine</title>
        <link rel="stylesheet" type="text/css" href="./css/style.css" />
        <script type="text/javascript" src="./js/jquery.js"></script>
        <script type="text/javascript" src="./js/cine.js"></script>
    </head>
    <body>
        <%!
        boolean lleno;
        %>
        <h3>Cine</h3>
        <form id="form" action="index.jsp" method="post">
            <table>
                <tr>
                    <th class="pantalla" colspan="11">Pantalla</th>
                </tr>
                <%
                char fila;
                int k = 0;
                lleno = true;
                for(int i=65; i < 73; i++) {
                    fila = (char)i;
                	out.println("<tr>");
                    out.println("<th>" + fila + "</th>");
                    for(int j = 1; j < 11; j ++) {
                        if(request.getParameter(fila + "-" + j) == null || request.getParameter(fila + "-" + j).equals("L")) {
                            out.println("<td>");
                            out.println("<a href=\"#\" onclick=\"jCine.seleccionar('" + k + "'); return false;\">" + j + "</a>");
                            //out.println("<input type=\"hidden\" id=\"" + k + "\" name=\"" + fila + "-" + j + "\" value=\"L\"");
                            lleno = false;
                        }
                        else{
                            out.println("<td class=\"vendida\">" + j);
                            out.println("<input type=\"hidden\" id=\"" + k + "\" name=\"" + fila + "-" + j + "\" value=\"V\"");
                        }                        
                        out.println("</td>");
                        k++;
                    }
                    out.println("</tr>");
                }                                           
                %>                
            </table>
            <div id="bloque-compra">
                <div id="compra">
                    <p>Ud. seleccion&oacute; las siguientes butacas: <span id="butacas"></span>
                    <br/><br/>
                    <a href="#" onclick="jCine.confirmar(); return false;">Confirmar</a>&nbsp;&nbsp;&nbsp;<a href="#" onclick="jCine.cancelar(); return false;">Cancelar</a>
                </div>
            </div>
            <br/>
            <%
            if(lleno) {
                out.println("<a href=\"index.jsp\">Iniciar Compra</a>");
            }
            else {
                out.println("<a href=\"#\" onclick=\"jCine.comprar(); return false;\">Comprar</a>");
            }        
            %>                
        </form>
    </body>
</html>
