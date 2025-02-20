package logica.excepciones;

public class EdadInvalidaException extends Exception{
	
	private String msg;
	
	public EdadInvalidaException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
