package logica.excepciones;

public class NoHayMiniDisponibleException extends Exception {
	
	private String msg;
	
	public NoHayMiniDisponibleException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
