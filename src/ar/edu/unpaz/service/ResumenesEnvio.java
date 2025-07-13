package ar.edu.unpaz.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ar.edu.unpaz.model.Envio;
import ar.edu.unpaz.repo.IArchivo;

public class ResumenesEnvio implements IResumenes{
	IArchivo archivo;
	public ResumenesEnvio(IArchivo archivo) {
		this.archivo = archivo;
	}
	
	public Double totalRecaudado() {
		
		try {
			return this.archivo
					.getEnvios()
					.stream()
					.mapToDouble(e -> e.calcularCosto())
					.sum();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	// Envío más caro y su resumen.
	public Envio masCaro() {
		List<Envio> envios = new ArrayList<Envio>();
		
		try {
			envios = this.archivo.getEnvios();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Envio[] aux = {envios.get(0)};
		
		envios.stream().forEach(e -> {
			if (e.calcularCosto() > aux[0].calcularCosto()) {
				aux[0] = e;
			}
			
		});
		
		return aux[0];
	}
	
	// Filtrar y mostrar todos los envíos a una ciudad dada.
	public List<Envio> filtroCiudad(String ciudad) {
		try {
			Map<String,List<Envio>> mapEnvios = DataMap.getMapCiudades(this.archivo.getEnvios());
				if (mapEnvios.containsKey(ciudad)) {
					return mapEnvios.get(ciudad);				
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ArrayList<Envio>();
	}
	
}
