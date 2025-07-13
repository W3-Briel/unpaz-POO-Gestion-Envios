package ar.edu.unpaz.model;

public class EnvioComun extends Envio{

	public EnvioComun(Cliente cliente, String destino, Double peso) {
		super(cliente, destino, peso);
		// TODO Auto-generated constructor stub
	}

	@Override // Común: $100 base + $5 por kg.
	public Double calcularCosto() {
		// TODO Auto-generated method stub
		return 100 + (this.getPeso() * 5);
	}

	@Override
	public String resumen() {
		return "Cliente: "+this.getCliente().getIdentificador()
				+" envio costo: $"+this.calcularCosto() + " tipo: Comun";
	}
	
}
