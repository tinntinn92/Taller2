package logica.boleto;

import java.util.ArrayList;

public class Boletos {
	
	private ArrayList<Boleto> boletos;
	
	
	public Boletos()
	{
		boletos = new ArrayList<Boleto>();
	}
	
	//Inserta un elemento en la coleccion
	public void insFront(Boleto b)
	{
		boletos.add(b);
	}
	
	//Devuelve la cantidad de elementos de la coleccion
	public int largo()
	{
		return boletos.size();
	}
	
	//Devuelve el elemento en la posicion ingresada
	public Boleto kesimo(int n)
	{
		return boletos.get(n);
	}
	
	//Devuelve si la coleccion esta vacia
	public boolean esVacia()
	{
		boolean es = false;
		
		if(boletos.size() == 0)
			es = true;
		return es;
	}
	//Devuelve un arreglo de objetos para listar
	/*public VOBoleto[] listarBoletos() 
	  {
	  
	  }
	  */
	
	
}
