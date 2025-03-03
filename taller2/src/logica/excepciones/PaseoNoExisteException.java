package logica.excepciones;

public class PaseoNoExisteException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public PaseoNoExisteException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
