package logica.paseo;
import java.time.LocalTime;
import java.util.TreeMap;

public class Paseos {
	
	private TreeMap<String,Paseo> paseos;
	
	public Paseos()
	{
		paseos = new TreeMap<String,Paseo>();
		
	}
	
	//Devuelve true si el elemento pertenece a la coleccion
	public boolean member(String key)
	{
		return paseos.containsKey(key);
	}
	
	//Devuelve el paseo seleccionado
	public Paseo find(String key)
	{
		return paseos.get(key);
	}
	
	//Inserta el Paseo a la coleccion
	public void insert(Paseo pa)
	{
		paseos.putIfAbsent(pa.getCodigo(), pa);
	}
	
	//Devuelve un arreglo con los paseos que coincida el destino ingresado
	//public VOPaseo[] listarPaseosDestino(String dest)
	
	//Devuelve un arreglo con todos los paseos
	//public VOPaseo[] listarPaseos()
	
	//Devuelve true si no hay ningun paseo que se solape en el horario
	public boolean disponibleEnHorario(LocalTime salida, LocalTime llegada)
	{
		boolean hay = true;
		
		for (String clave : paseos.keySet())
		{
			Paseo paseo = paseos.get(clave);
			
			if (!(salida.isAfter(paseo.getHoraLlegada()) || llegada.isBefore(paseo.getHoraPartida())))
			{
				hay = false;
				break;
			}
		}
		
		return hay;
	}

}
