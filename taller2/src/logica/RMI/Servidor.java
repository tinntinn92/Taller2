package logica.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import logica.CapaLogica;

public class Servidor {
	
	public static void main(String[] args)
	{
		try {
			LocateRegistry.createRegistry(3000);
			
			CapaLogica fachada = new CapaLogica();
			
			Naming.rebind("localhost:3000/principal", fachada);
			
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
