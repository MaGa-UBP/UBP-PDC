<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<p> Variable 1: <%= request.getParameter("variable1") %></p>
<p> Variable 2: <%= request.getParameter("variable2") %></p>
<a href="#" onclick="jForm.volver()">Volver</a>