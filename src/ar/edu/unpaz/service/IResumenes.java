package ar.edu.unpaz.service;

import java.util.List;

import ar.edu.unpaz.model.Envio;

public interface IResumenes {
	Envio masCaro();
	Double totalRecaudado();
	List<Envio> filtroCiudad(String ciudad);
}