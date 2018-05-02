<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.Date, java.util.Locale, java.text.DateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Ejemplo 6</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
<%
Locale     locale;
DateFormat df;
String     date;

locale = request.getLocale();
df     = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
date   = df.format(new Date());
%>        
<jsp:forward page="./ejemplo6-res.jsp">
    <jsp:param name="date" value="<%= date %>"/>
</jsp:forward>
</body>
</html>