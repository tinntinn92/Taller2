package logica;

import java.io.Serializable;

public class Monitor implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private static Monitor instancia;
	private int lectores;
	private boolean escribiendo;
	
	private Monitor()
	{
		lectores = 0;
		escribiendo = false;
	}
	
	public static Monitor getInstancia()
	{
		if(instancia == null)
			instancia = new Monitor();
		
		return instancia;
	}
	
	public synchronized void comienzoLectura()
	{
		while(escribiendo)
		{		
				try 
				{
					wait();
					
				} catch (InterruptedException e)
				{

				}
				
				lectores++;

		}
		
	}
	
	public synchronized void terminoLectura()
	{
		lectores--;
		
		if(lectores == 0)
		{
			notifyAll();
		}
		
	}
	
	public synchronized void comienzoEscritura()
	{
		while(escribiendo || lectores >0)
		{
			try {
				wait();
				
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		escribiendo = true;
		
	}
	
	public synchronized void terminoEscritura()
	{
		escribiendo = false;
		
		notifyAll();
		
		
	}

}
