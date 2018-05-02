package ar.edu.ubp.das.ws;

import java.util.LinkedList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ar.edu.ubp.das.bean.CategoriaBean;

@WebService(name = "ICategorias", targetNamespace = "http://ws.das.ubp.edu.ar/")
public interface ICategorias {

	@WebMethod(operationName = "getCategorias", action = "urn:GetCategorias")
	LinkedList<CategoriaBean> getCategorias() throws Exception;

}