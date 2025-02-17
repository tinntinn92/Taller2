package logica.valueObjects;

import java.time.LocalTime;

public class VOPaseo extends VOIngresoPaseo{
	
	private int cantMaxBoletosVendible;
	private int cantBoletosComprados;
	
	public VOPaseo(String cod, String des, LocalTime lle, LocalTime sal, double pre, int max, int comp)
	{
		super(cod, des, lle, sal, pre);
		
		cantMaxBoletosVendible = max;
		cantBoletosComprados = comp;
	}
	
	//Devuelve la cantidad maxima de boletos vendibles
	public int getCantMaxBoletosVendible()
	{
		return cantMaxBoletosVendible;
	}
	
	//Devuelve la cantidad de boletos comprados
	public int getCantBoletosComprados()
	{
		return cantBoletosComprados;
	}

}
