package logica.excepciones;

public class SinBoletosDispoiblesException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public SinBoletosDispoiblesException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
