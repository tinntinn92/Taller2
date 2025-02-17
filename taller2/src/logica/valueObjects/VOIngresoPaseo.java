package logica.valueObjects;

import java.time.LocalTime;

public class VOIngresoPaseo {
	
	private String codigo;
	private String destino;
	private LocalTime horaLlegada;
	private LocalTime horaSalida;
	private double precioBase;
	
	public VOIngresoPaseo(String cod, String des, LocalTime lle, LocalTime sal, double pre)
	{
		codigo = cod;
		destino = des;
		horaLlegada = lle;
		horaSalida = sal;
		precioBase = pre;
	}
	
	//Devuelve el codigo del paseo
	public String getCodigo()
	{
		return codigo;
	}
	
	//Deuvle el destino del paseo
	public String getDestino()
	{
		return destino;
	}
	
	//Devuelve la hora de llegada
	public LocalTime getHoraLlegada()
	{
		return horaLlegada;
	}
	
	//Devuelve la hora de salida
	public LocalTime getHoraSalida()
	{
		return horaSalida;
	}
	
	//Devuelve el precio base
	public double getPrecioBase()
	{
		return precioBase;
	}
	
}
