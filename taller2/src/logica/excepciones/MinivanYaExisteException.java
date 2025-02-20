package logica.excepciones;

public class MinivanYaExisteException extends Exception{

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
