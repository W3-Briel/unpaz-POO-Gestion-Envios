package ar.edu.unpaz.model;

public abstract class Envio {
	private Cliente cliente;
	private String destino;
	private Double peso;
	
	public Envio(Cliente cliente, String destino, Double peso) {
		super();
		this.cliente = cliente;
		this.destino = destino;
		this.peso = peso;
	}
	public abstract Double calcularCosto();
	public abstract String resumen();
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	
}
