package logica.excepciones;

public class CantAsientosIncorrectaException extends Exception{
	
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
