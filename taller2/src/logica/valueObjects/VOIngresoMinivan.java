package logica.valueObjects;

public class VOIngresoMinivan {
	
	private String matricula;
	private String marca;
	private String modelo;
	private int cantAsientos;
	
	public VOIngresoMinivan(String mat, String mar, String mod, int cant)
	{
		matricula = mat;
		marca= mar;
		modelo = mod;
		cantAsientos = cant;
	}
	
	//Devuelve la matricula
	public String getMatricula()
	{
		return matricula;
	}
	//Deuelve la marca
	public String getMarca()
	{
		return marca;
	}
	
	//Devuelve el modelo
	public String getModelo()
	{
		return modelo;
	}
	
	//Deuvleve la cantida de asientos
	public int getCantAsientos()
	{
		return cantAsientos;
	}
}
