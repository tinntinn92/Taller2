package logica.excepciones;

public class CelularInvalidoException extends Exception {
	
	private String msg;
	
	public CelularInvalidoException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
