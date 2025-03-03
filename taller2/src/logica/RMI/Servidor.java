package logica.RMI;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;
import java.io.FileInputStream;

import logica.CapaLogica;

public class Servidor {
	
	public static void main(String[] args)
	{
		try {
            // Cargar el archivo de configuración
            Properties config = new Properties();
            config.load(new FileInputStream("config/config.properties"));

            // Obtener los valores de configuración
            String ip = config.getProperty("rmi.server.ip");
            int port = Integer.parseInt(config.getProperty("rmi.server.port"));
            String name = config.getProperty("rmi.server.name");
 
            // Crea una instancia de la Fachada
            CapaLogica fachada = new CapaLogica();
            
            // Pongo a correr el registro RMI en el puerto especificado
            LocateRegistry.createRegistry(port);
            
            // Registra el objeto remoto con un nombre
            //registro.rebind(name, fachada);
            Naming.rebind("//"+ip+":"+port+"/"+name+"", fachada);

            System.out.println("Servidor RMI listo en " + ip + ":" + port + " con nombre " + name);
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
		

	}

}
