package logica.excepciones;

public class MinivanYaExisteException extends Exception{

	private static final long serialVersionUID = 1L;
	private String msg;
	
	public MinivanYaExisteException(String mensaje)
	{
		msg = mensaje;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}
}
