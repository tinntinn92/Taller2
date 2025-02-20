package logica.valueObjects;

public class VOIngresoBoleto extends VOBoleto{
	
	private String paseo;
	
	public VOIngresoBoleto(int num, String nom, int ed, long cel, int desc, String pas)
	{
		super(num, nom, ed, cel, desc);
		paseo = pas;
	}
	
	//Devuelve el codigo del paseo
	public String getCodigoPaseo()
	{
		return paseo;
	}

}
