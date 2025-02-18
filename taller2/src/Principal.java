
import java.time.LocalTime;

import logica.boleto.*;
import logica.paseo.*;
import logica.valueObjects.*;

public class Principal {

	public static void main(String[] args) {
		
		Boleto bol = new Boleto(0, "Manuel", 54, 267436);
		Boleto bol2 = new Boleto(3, "	Maria", 15, 287431);
		Especial espe = new Especial(1, "Esteban", 7, 267436, 50);
		Paseo pa = new Paseo("PDE001", "Punta del este", LocalTime.of(15, 00), LocalTime.of(18, 00), 1600, 10);
		Paseo ps2 = new Paseo("MVD002", "Montevideo", LocalTime.of(15, 00), LocalTime.of(22, 00), 1200, 15);
		Paseo pa3 = new Paseo("PIR003", "Piriapolis", LocalTime.of(16, 00), LocalTime.of(17, 00), 2200, 20);
		Paseos dic = new Paseos();
		 
		
		System.out.println(pa.getCodigo() + "\n");
		System.out.println(pa.getDestino() + "\n");
		System.out.println(pa.getHoraPartida() + "\n");
		System.out.println(pa.getHoraLlegada() + "\n");
		System.out.println(pa.getPrecioBase() + "\n");
		System.out.println(pa.getCantMaxBoletosVendibles() + "\n");
		System.out.println(pa.largoBoletos() + "\n");
		
		pa.insertarBoleto(bol);
		pa.insertarBoleto(espe);
		ps2.insertarBoleto(bol2);
		
		System.out.println(pa.contarRecaudado() + "\n");
		System.out.println(pa.largoBoletos() + "\n");
		
		//dic.insert(pa);
		dic.insert(ps2);
		
		if(dic.member(pa.getCodigo()))
		{
			System.out.println("\n el paseo esta en el diccionario");
		}else
			System.out.println("\n el paseo NO esta en el diccionario");
		
		if(dic.disponibleEnHorario(pa3.getHoraPartida(),pa3.getHoraLlegada()))
			System.out.println("\n No Se solapan");
		
		
		


		
		
	}

}
