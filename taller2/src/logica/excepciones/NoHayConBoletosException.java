package logica.excepciones;

public class NoHayConBoletosException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public NoHayConBoletosException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
