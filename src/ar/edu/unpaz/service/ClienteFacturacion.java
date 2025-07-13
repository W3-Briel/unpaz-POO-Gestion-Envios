package ar.edu.unpaz.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ar.edu.unpaz.model.Envio;
import ar.edu.unpaz.repo.IArchivo;

public class ClienteFacturacion implements IFacturable{

	IArchivo archivo;
	
	public ClienteFacturacion(IArchivo archivo) {
		this.archivo = archivo;
	}
	
	@Override
	public Double getMonto(String id) {
		List<Envio> envios = new ArrayList<Envio>();
		try {
			envios = this.archivo.getEnvios();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String,List<Envio>> clienteEnvios = DataMap.getMapClientes(envios);
		
		if (clienteEnvios.containsKey(id)) {
			return clienteEnvios.get(id).stream()
					.mapToDouble(envio -> envio.calcularCosto())
					.sum();
		}
		
		return 0.0;
	}
	
}
