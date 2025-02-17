package logica.boleto;

public class Especial extends Boleto {
	
	private int descuento;
	
	public Especial(int num, String nom, int ed, long cel, int des)
	{
		super(num, nom, ed, cel);
		descuento = des;
	}
	
	//Devuelve el descuento
	public int getDescuento()
	{
		return descuento;
	}
	
	//Devuelve si es especial
	public boolean getEsEspecial()
	{
		return true;
	}
	

}
