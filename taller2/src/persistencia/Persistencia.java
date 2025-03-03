package persistencia;

import java.io.*;
import logica.excepciones.PersistenciaException;
import logica.minivan.Minivanes;
import logica.paseo.Paseos;

public class Persistencia {
	
	public void respaldar (String nomArch, Paseos paseos, Minivanes minivans) throws PersistenciaException
	{
		try 
		{
			
		FileOutputStream f = new FileOutputStream(nomArch);
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		o.writeObject (paseos);
		o.writeObject (minivans);
		o.close();
		f.close();
		}
		catch (IOException e)
		{
		e.printStackTrace();
		throw new PersistenciaException("error respaldar");
		}
	}
	
	public Object[]  recuperar (String nomArch) throws PersistenciaException, ClassNotFoundException 
	{
		{
			try
			{
			
				FileInputStream f = new FileInputStream(nomArch);
				ObjectInputStream o = new ObjectInputStream(f);					
	            Paseos paseos = (Paseos) o.readObject();
	            Minivanes minivans = (Minivanes) o.readObject();		
				o.close();			
				f.close();			
				return new Object[]{paseos, minivans};
			}
			catch (IOException e)
			{
				e.printStackTrace();
				throw new PersistenciaException("Error al recuperar");
			}
			catch(ClassNotFoundException  e)
			{
				throw new ClassNotFoundException ("Error al recuperar: Clase no encontrada");
			}
		}
	}
	

			

}
