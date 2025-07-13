package ar.edu.unpaz.repo;

import java.io.IOException;
import java.util.List;

import ar.edu.unpaz.model.Envio;

public interface IArchivo {
	public List<Envio> getEnvios() throws IOException;
	public void SetNuevoEnvio();
}
