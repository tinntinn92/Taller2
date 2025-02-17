package logica.valueObjects;

public class VOMinivan extends VOIngresoMinivan{
	
	private int totPaseosAsignados;
	
	public VOMinivan(String mat, String mar, String mod, int cant, int pas)
	{
		super(mat, mar, mod, cant);
		totPaseosAsignados = pas;
	}
	
	//Devuelve la cantidad de paseos asignados
	public int getTotPaseosAsignados()
	{
		return totPaseosAsignados;
	}

}
