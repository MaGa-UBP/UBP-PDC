<%@taglib uri="/WEB-INF/tld/customs.tld" prefix="tl" %>
<%String cod_tipo_serv = request.getParameter("sel-serv");%>
<tl:temas nombre="sel-tema" codTipoServicio="<%=cod_tipo_serv%>" />