package ar.edu.unpaz.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ar.edu.unpaz.model.Envio;
import ar.edu.unpaz.service.IFacturable;
import ar.edu.unpaz.service.IResumenes;

public class Menu {
	private IResumenes servResu;
	private IFacturable servFactu;
	
	public Menu (IResumenes servResu, IFacturable facturableServ) {
		this.servResu = servResu;
		this.servFactu = facturableServ;
	}
	
	public void consola() {
		
		boolean bandera = true;
		Scanner s = new Scanner(System.in);
		
		while (bandera) {
			
			System.out.println("");
			System.out.println("menu:\t1) filtro ciudad.");
			System.out.println("\t2) monto total");
			System.out.println("\t3) envio mas caro");
			System.out.println("\t4) obtener factura");
			System.out.println("--- para salir ingresa cualquier opcion no mostrada\n Opcion: ");
			System.out.println("");
			char option = s.next().charAt(0);
			
			switch (option) {
			case '1':
				System.out.println("ingrsa la ciudad");
				String ciudad = s.next();
				
				this.ciudad(ciudad);
				break;
			case '2':
				this.monto();
				break;
			case '3':
				this.masCaro();
				break;
			case '4':
				System.out.println("ingrsa la id: ");
				String id = s.next();
				
				this.getMonto(id);
				break;
			default:
				bandera = false;
				System.out.println("bueno chau amigo");
			}
						
		}
		
	}
	
	public void ciudad(String ciudad) {
		List<Envio> aux = this.servResu.filtroCiudad(ciudad);
		
		System.out.println("---------- los envios en esta ciudad: ");
		if(aux.size() == 0) {
			System.out.println("no hay envios para esa ciudad");
		} else {
			aux.forEach(e -> System.out.print(e.resumen()+"\n"));
		}
	}
	
	public void getMonto(String id) {
		System.out.println("la factura es de ----> $ "+ this.servFactu.getMonto(id)+"\n");
	}
	
	public void monto() {
		System.out.print("el monto total recaudado es: " + this.servResu.totalRecaudado());
	}
	public void masCaro() {
		System.out.println("el envio mas caro es; ");
		System.out.println(this.servResu.masCaro().resumen());
	}
	
}
