package logica.excepciones;

public class MinivanNoExisteException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public MinivanNoExisteException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
