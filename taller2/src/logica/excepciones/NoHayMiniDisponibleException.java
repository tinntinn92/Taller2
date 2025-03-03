package logica.excepciones;

public class NoHayMiniDisponibleException extends Exception {
	
	
	private static final long serialVersionUID = 1L;
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
