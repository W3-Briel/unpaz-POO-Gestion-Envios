package ar.edu.unpaz.main;

import ar.edu.unpaz.controller.Menu;
import ar.edu.unpaz.repo.Archivo;
import ar.edu.unpaz.service.ClienteFacturacion;
import ar.edu.unpaz.service.ResumenesEnvio;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//repo
		Archivo archivo = new Archivo("C:\\Users\\Angel\\OneDrive\\Desktop\\workspace\\workspace poo\\envios.txt");
		
		//serv
		ResumenesEnvio servEnvios = new ResumenesEnvio(archivo);
		ClienteFacturacion facturableServ = new ClienteFacturacion(archivo);
		
		//view
		Menu menu = new Menu(servEnvios,facturableServ);
		
		menu.consola();
	}
}
