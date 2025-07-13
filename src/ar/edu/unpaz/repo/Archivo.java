package ar.edu.unpaz.repo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unpaz.model.Cliente;
import ar.edu.unpaz.model.Envio;
import ar.edu.unpaz.model.EnvioComun;
import ar.edu.unpaz.model.EnvioUrgente;

public class Archivo implements IArchivo{
	private Path url;
	
	public Archivo(String path) {
		this.url = Paths.get(path);
	}

	@Override
	public List<Envio> getEnvios() throws IOException {
		List<String[]> lines = Files.readAllLines(url)
				.stream()
				.map(line -> line.split(";"))
				.collect(Collectors.toList());

		lines.remove(0); // borramos las columnas
		
		// nombreCliente;dniCliente;ciudadDestino;tipoServicio;peso				
		List<Envio> data = new ArrayList<Envio>();
		
		
		lines.stream().forEach(l -> {
			if( l.length > 5) new Error("Un dato en el archivo no sigue el formato esperado");
			
			// Cliente cliente, String destino, Double peso
			Cliente c = new Cliente(l[0],l[1]);
			Envio envio = l[3].equalsIgnoreCase("urgente")
					? new EnvioUrgente(c,l[2],Double.parseDouble(l[4]))
					: new EnvioComun(c,l[2],Double.parseDouble(l[4]));
			
			data.add(envio);
		});
		
		return data;
	}	

	@Override
	public void SetNuevoEnvio() {
		// TODO Auto-generated method stub
		
	}

	
}
