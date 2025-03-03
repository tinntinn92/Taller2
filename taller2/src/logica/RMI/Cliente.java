package logica.RMI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import logica.ICapaLogica;

public class Cliente {
	
	public static void main(String [] args)
	{
		try
		{
			 Properties config = new Properties();
			 config.load(new FileInputStream("config/config.properties"));
			 
			 // Obtener los valores de configuración
			 String ip = config.getProperty("rmi.server.ip");
			 int port = Integer.parseInt(config.getProperty("rmi.server.port"));
			 String name = config.getProperty("rmi.server.name");
	 
			 ICapaLogica fachada = (ICapaLogica) Naming.lookup("//"+ip+":"+port+"/"+name+"");
			 
			 System.out.println("Conectado a: " + ip + ":" + port + " con nombre " + name);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
