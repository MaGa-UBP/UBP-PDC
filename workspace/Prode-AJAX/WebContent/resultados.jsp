<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"
import="ar.edu.ubp.pdc.classes.Calculator"  %>
<%
   
String [] resEq = request.getParameterValues("resultado");

List<List<Short>> resultados = new ArrayList<List<Short>>();
/*for(i = 0; i < equipos.size(); i++) {
	resultados.add(Arrays.asList(Double.class.cast(Math.random() * 6).shortValue(), Double.class.cast(Math.random() * 6).shortValue()));	
}*/
%>	
	<form id="form" action="index.jsp" method="post">
	
		<%
		String formulas = request.getParameter( "formulas" );
		String resultados = request.getParameter( "resultados" );
		String ultimaFormula = request.getParameter( "ultimaFormula" );
		
		String ultimoResultado = null;
		if( ultimaFormula != null )
			ultimoResultado = Calculator.calculate( ultimaFormula);
		%>
		
		<input name="formulas" type="hidden" value="<%
		if( formulas != null && !formulas.equals( "" ) ) {
			out.print( formulas );
		}
		if( ultimaFormula != null && !ultimaFormula.equals( "" ) ) {
			out.print( ultimaFormula + ";" );
		}
		%>"/>
		
		<input name="resultados" type="hidden" value="<%
		if( resultados != null && !resultados.equals( "" ) ) {
			out.print( resultados );
		}
		if( ultimoResultado != null && !ultimoResultado.equals( "" ) ) {
			out.print( ultimoResultado + ";" );
		}
		%>"/>
		
		<input id="uf" name="ultimaFormula" type="hidden" value=""/>
	
	</form>
	<div class="box">
	<%
	
	if( ( formulas != null && !formulas.equals( "" ) ) ||
	    ( ultimaFormula != null && !ultimaFormula.equals( "" ) ) ) {
		out.print( "<h3>Fórmula</h3>" );
	}
	
	if( formulas != null && !formulas.equals( "" ) ) {
		String[] fs = formulas.split( ";" );
		for( int i = 0; i < fs.length; i++ ) {
			out.print( "<br />" );
			out.print( fs[i] );
		}
	}
	
	if( ultimaFormula != null && !ultimaFormula.equals( "" ) ) {
		out.print( "<br />" );
		out.print( ultimaFormula );
	}
	
	%>
	</div>
	<div class="box">
	<%
	
	if( ( resultados != null && !resultados.equals( "" ) ) ||
	    ( ultimoResultado != null && !ultimoResultado.equals( "" ) ) ) {
		out.print( "<h3>Resultado</h3>" );
	}
	
	if( resultados != null && !resultados.equals( "" ) ) {
		String[] rs = resultados.split( ";" );
		for( int i = 0; i < rs.length; i++ ) {
			out.print( "<br />" );
			out.print( rs[i] );
		}
	}
	
	if( ultimoResultado != null && !ultimoResultado.equals( "" ) ) {
		out.print( "<br />" );
		out.print( ultimoResultado );
	}
	%>
	</div>


   