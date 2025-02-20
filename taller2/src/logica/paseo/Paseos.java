package logica.paseo;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TreeMap;

import logica.valueObjects.VOPaseo;

public class Paseos {
	
	private TreeMap<String,Paseo> paseos;
	
	public Paseos()
	{
		paseos = new TreeMap<String,Paseo>();
		
	}
	
	//Devuelve true si el elemento pertenece a la coleccion
	public boolean member(String key)
	{
		return paseos.containsKey(key);
	}
	
	//Devuelve el paseo seleccionado
	public Paseo find(String key)
	{
		return paseos.get(key);
	}
	
	//Inserta el Paseo a la coleccion
	public void insert(Paseo pa)
	{
		paseos.putIfAbsent(pa.getCodigo(), pa);
	}
	
	//Devuelve la cantidad de objetos en la coleccion
	public int largo()
	{
		return paseos.size();
	}
	
	//Devuelve un arreglo con los paseos que coincida el destino ingresado
	public VOPaseo[] listarPaseosDestino(String dest)
	{
		VOPaseo aux [];
		ArrayList<String> lis = new ArrayList<String>();
		int i=0;
		
		for(Paseo clave : paseos.values())
		{
			if(clave.getDestino().equals(dest))
				lis.add(clave.getCodigo());
		}
		
		aux = new VOPaseo[lis.size()];

		for(String clave : lis)
		{
			Paseo buffer = paseos.get(clave);
			
			aux[i] = new VOPaseo(buffer.getCodigo(), buffer.getDestino(), buffer.getHoraLlegada(), buffer.getHoraPartida(), buffer.getPrecioBase(), buffer.getCantMaxBoletosVendibles(), buffer.largoBoletos());
				
			i++;
		}

		
		return aux;
		
		
		
	}
	
	//Devuelve un arreglo con los paseos que tengan por lo menos la cantida dde boletos dispoibles
	public VOPaseo[] listarPaseosBoletosDispoibles(int cant)
	{
		VOPaseo aux [];
		ArrayList<String> lis = new ArrayList<String>();
		int i=0;
		
		for(Paseo clave : paseos.values())
		{
			if(clave.disponibles() >= cant)
				lis.add(clave.getCodigo());
		}
		
		aux = new VOPaseo[lis.size()];

		for(String clave : lis)
		{
			Paseo buffer = paseos.get(clave);
			
			aux[i] = new VOPaseo(buffer.getCodigo(), buffer.getDestino(), buffer.getHoraLlegada(), buffer.getHoraPartida(), buffer.getPrecioBase(), buffer.getCantMaxBoletosVendibles(), buffer.largoBoletos());
				
			i++;
		}

		
		return aux;
		
		
		
	}	
	
	
	//Devuelve un arreglo con todos los paseos
	public VOPaseo[] listarPaseos()
	{
		VOPaseo aux [] = new VOPaseo[paseos.size()];
		int i = 0;
		
		for(Paseo pa : paseos.values())
		{
			aux[i] = new VOPaseo(pa.getCodigo(),pa.getDestino(), pa.getHoraLlegada(), pa.getHoraPartida(), pa.getPrecioBase(), pa.getCantMaxBoletosVendibles(), pa.largoBoletos());
			
			i++;
		}
		
		return aux;
	}
	
	//Devuelve true si no hay ningun paseo que se solape en el horario
	public boolean disponibleEnHorario(LocalTime salida, LocalTime llegada)
	{
		boolean hay = true;
		
		for (String clave : paseos.keySet())
		{
			Paseo paseo = paseos.get(clave);
			
			if (!(salida.isAfter(paseo.getHoraLlegada()) || llegada.isBefore(paseo.getHoraPartida())))
			{
				hay = false;
				break;
			}
		}
		
		return hay;
	}

}
