package logica.excepciones;

public class PaseoYaExisteException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public PaseoYaExisteException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
