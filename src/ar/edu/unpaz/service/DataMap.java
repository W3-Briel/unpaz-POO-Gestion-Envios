package ar.edu.unpaz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.edu.unpaz.model.Envio;

public final class DataMap {
	
	private DataMap() {};
	
	public static Map<String, List<Envio>> getMapCiudades(List<Envio> envios) {
		
		Map<String,List<Envio>> data = new HashMap<>();
		
		envios.stream()
			.forEach(envio -> {
				data.computeIfAbsent(envio.getDestino(), k -> new ArrayList<Envio>())
				.add(envio);
			});
		
		return data;
	}
	
	public static Map<String, List<Envio>> getMapClientes(List<Envio> envios){
		
		Map<String,List<Envio>> data = new HashMap<>();
		
		envios.stream()
			.forEach(envio -> {
				data.computeIfAbsent(envio.getCliente().getIdentificador(), k -> new ArrayList<Envio>())
				.add(envio);
			});
		
		return data;
	}

}
