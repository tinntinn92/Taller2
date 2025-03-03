package logica.excepciones;

public class NoHayVendidosException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public NoHayVendidosException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
	}	
	

}
