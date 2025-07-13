package ar.edu.unpaz.model;

public class EnvioUrgente extends Envio{

	public EnvioUrgente(Cliente cliente, String destino, Double peso) {
		super(cliente, destino, peso);
		// TODO Auto-generated constructor stub
	}

	@Override //Urgente: $200 base + $10 por kg.
	public Double calcularCosto() {
		
		return 200 + (this.getPeso() * 10);
	}

	@Override
	public String resumen() {
		// TODO Auto-generated method stub
		return "Cliente: "+this.getCliente().getIdentificador()
				+" envio costo: $"+this.calcularCosto() + " tipo: Urgente";
	}

}
