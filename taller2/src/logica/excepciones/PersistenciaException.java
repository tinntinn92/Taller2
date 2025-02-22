package logica.excepciones;

public class PersistenciaException extends Exception {
	
	private String msg;
	
	public PersistenciaException(String m)
	{
		msg = m;
	}
	
	public String darMensaje()
	{
		return msg;
		
	}

}
