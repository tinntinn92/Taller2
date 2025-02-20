package logica.excepciones;

public class SinBoletosDispoiblesException extends Exception{
	
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
