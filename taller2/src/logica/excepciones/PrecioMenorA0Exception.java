package logica.excepciones;

public class PrecioMenorA0Exception extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public PrecioMenorA0Exception(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
