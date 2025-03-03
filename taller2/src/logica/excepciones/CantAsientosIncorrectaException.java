package logica.excepciones;

public class CantAsientosIncorrectaException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public CantAsientosIncorrectaException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
