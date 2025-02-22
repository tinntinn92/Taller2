package logica.paseo;

import java.io.Serializable;
import java.time.LocalTime;

import logica.boleto.*;
import logica.valueObjects.VOBoleto;

public class Paseo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String destino;
	private LocalTime horaLlegada;
	private LocalTime horaPartida;
	private double precioBase;
	private int cantMaxBoletosVendibles;
	private Boletos boletosComprados;
	
	public Paseo(String cod, String dest, LocalTime part, LocalTime lle, double pre, int cant)
	{
		codigo = cod;
		destino = dest;
		horaLlegada = lle;
		horaPartida = part;
		precioBase = pre;
		cantMaxBoletosVendibles = cant;
		boletosComprados = new Boletos();
	}
	
	//Devuelve el codigo
	public String getCodigo()
	{
		return codigo;
	}
	
	//Devuelve el destino
	public String getDestino()
	{
		return destino;
	}
	
	//Devuelve la hora de llegada
	public LocalTime getHoraLlegada()
	{
		return horaLlegada;
	}
	
	//Devuelve la hora de partida
	public LocalTime getHoraPartida()
	{
		return horaPartida;
		
	}

	//Devuelve el precio base
	public double getPrecioBase()
	{
		return precioBase;
	}
	
	//Devuelve la cantidad maxima de boletos vendibles
	public int getCantMaxBoletosVendibles()
	{
		return cantMaxBoletosVendibles;
	}
	
	//Devuelve los boletos comprados
	public Boletos getBoletosComprados()
	{
		return boletosComprados;
	}
	
	//Devuelve un arreglo de boletos comprados
	public VOBoleto[] listarBoletosComprados()
	{
		return boletosComprados.listarBoletos();
	}
	
	//Devuelve el total recaudado del paseo
	public double contarRecaudado()
	{
		double total = 0, aux, descuento;
		
		for(int i = 0; i< boletosComprados.largo(); i++)
		{
			if(boletosComprados.kesimo(i).getEdadPasajero() < 18)
				aux = precioBase * 0.75;
			else
				aux = precioBase;
			
			if(boletosComprados.kesimo(i).getEsEspecial())
			{
				
				descuento = aux * ((Especial) boletosComprados.kesimo(i)).getDescuento() / 100;
				aux -= descuento;
				total = total + aux;
				
			}else
			{
				total = total + precioBase;
			}
		}
		
		return total;
	}
	
	//Inserta un boleto en los boletos vendidos
	public void insertarBoleto(Boleto b)
	{
		boletosComprados.insFront(b);
	}
	
	//Devuelve true si no hay boletos vendidos para el paseo
	public boolean boletoEsVacia()
	{
		boolean es = false;
		
		if(boletosComprados.largo() == 0)
			es = true;
		
		return es;
	}
	
	//Devuelva la cantidad de boletos vendidos para el paseo
	public int largoBoletos()
	{
		return boletosComprados.largo();
	}
	
	//Devuelve la cantida de boletos dispoibles
	public int disponibles()
	{
		return cantMaxBoletosVendibles - boletosComprados.largo();
	}
	

}
