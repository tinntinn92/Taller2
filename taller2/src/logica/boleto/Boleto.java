package logica.boleto;

import java.io.Serializable;

public class Boleto implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int numero;
	private String nombrePasajero;
	private int edadPasajero;
	private long numeroCelular;
	
	public Boleto(int n, String s, int e, long c)
	{
		numero = n;
		nombrePasajero = s;
		edadPasajero = e;
		numeroCelular = c;
	}
	
	//Devuelve el numero
	public int getNumero()
	{
		return numero;
	}
	
	//Devuelve el nombre
	public String getNombrePasajero()
	{
		return nombrePasajero;
	}
	
	//Devuelve la edad
	public int getEdadPasajero()
	{
		return edadPasajero;
	}
	
	//Devuelve el numero de celular
	public long getNumeroCelular()
	{
		return numeroCelular;
	}
	
	//Devuelve si es especial
	public boolean getEsEspecial()
	{
		return false;
	}
	

}
