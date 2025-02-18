package logica.minivan;

import java.time.LocalTime;

import logica.paseo.*;
import logica.valueObjects.VOPaseo;

public class Minivan {
	
	private String matricula;
	private String marca;
	private String modelo;
	private int cantAsientos;
	private Paseos paseosAsignados;
	
	public Minivan(String mat, String marc, String mod, int cant)
	{
		matricula = mat;
		marca = marc;
		modelo= mod;
		cantAsientos = cant;
		paseosAsignados = new Paseos();
	}
	
	//Devuelve la matricula
	public String getMatricula()
	{
		return matricula;
	}
	
	//Devuelve la marca
	public String getMarca()
	{
		return marca;
	}
	
	//Devuelve el modelo
	public String getModelo()
	{
		return modelo;
	}
	
	//Devuelve la cantidad de asientos
	public int getCantAsientos()
	{
		return cantAsientos;
	}
	
	//Devuelve los paseos de la minivan
	public Paseos getPaseosAasignados()
	{
		return paseosAsignados;
	}
	
	//Agrega un paseo a la minivan
	public void agregarPaseo(Paseo pa)
	{
		paseosAsignados.insert(pa);
	}
	
	//Devuelve un arreglo con los paseos de la minivan
	public VOPaseo[] listarPaseos()
	{
		return paseosAsignados.listarPaseos();
		
	}
	
	//Devuelve true si hay horario disponible para agregar el paseo
	public boolean disponibleEnHorario(LocalTime salida, LocalTime llegada)
	{
		return paseosAsignados.disponibleEnHorario(salida, llegada);
	}
	
	

}
