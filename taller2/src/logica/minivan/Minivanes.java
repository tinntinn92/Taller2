package logica.minivan;

import java.util.TreeMap;

public class Minivanes {
	
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
	//public VOMinivan[] listarMinivanes()
	

}
