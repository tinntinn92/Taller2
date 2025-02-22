package logica.excepciones;

public class NoHayConDestinoException extends Exception {
	
	private String msg;
	
	public NoHayConDestinoException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
