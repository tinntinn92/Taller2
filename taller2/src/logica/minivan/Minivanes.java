package logica.minivan;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.TreeMap;

import logica.valueObjects.VOMinivan;

public class Minivanes implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private TreeMap<String, Minivan> minivanes;
	
	public Minivanes()
	{
		minivanes = new TreeMap<String, Minivan>();
	}
	
	//Devuelve true si la minivan pertenece a la coleccion
	public boolean member(String key)
	{
		return minivanes.containsKey(key);
	}
	
	//Devuelve la minivan seleccionada
	public Minivan find(String key)
	{
		return minivanes.get(key);
	}
	
	//Inserta la minivan en la coleccion
	public void insert(Minivan mini)
	{
		minivanes.putIfAbsent(mini.getMatricula(), mini);
	}
	
	//Devuelve un arreglo de todas las minivanes de la coleccion
	public VOMinivan[] listarMinivanes()
	{
		int i = 0;
		VOMinivan aux [] = new VOMinivan[minivanes.size()];
		
		for(Minivan mini : minivanes.values())
		{
			aux[i] = new VOMinivan(mini.getMatricula(), mini.getMarca(), mini.getModelo(), mini.getCantAsientos(), mini.getPaseosAasignados().largo());
			
			i++;
		}
		
		return aux;
	}
	
	//Devuelve la primer minivan disponible en el horario
	public Minivan primeraDisponible(LocalTime salida, LocalTime llegada)
	{
		Minivan resu = null;
		
		for(Minivan mini : minivanes.values())
		{
			if(mini.disponibleEnHorario(salida, llegada))
			{
				resu = mini;
				break;
			}
		}
		
		return resu;
				
	}

}
