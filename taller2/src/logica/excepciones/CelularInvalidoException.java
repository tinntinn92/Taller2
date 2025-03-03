package logica.excepciones;

public class CelularInvalidoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
