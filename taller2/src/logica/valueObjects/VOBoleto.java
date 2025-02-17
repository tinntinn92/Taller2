package logica.valueObjects;

public class VOBoleto {
	
	private int numero;
	private String nombrePasajero;
	private int edadPasajero;
	private long numeroCelular;
	private double descuento;
	
	public VOBoleto(int num, String nom, int ed, long cel, double desc)
	{
		numero = num;
		nombrePasajero = nom;
		edadPasajero = ed;
		numeroCelular = cel;
		descuento = desc;
	}
	
	//devuelve el numero de boleto
	public int getNumero()
	{
		return numero;
	}
	
	//devuelve el nombre del pasajero
	public String getNombrePasajero()
	{
		return nombrePasajero;
	}
	
	//Devuelve la edad del pasajero
	public int getEdadPasajero()
	{
		return edadPasajero;
	}
	
	//Devuelve el numero de celular
	public long getNumeroCelular()
	{
		return numeroCelular;
	}
	
	//Devuelve el descuento
	public double getDescuento()
	{
		return descuento;
	}
	
	

}
