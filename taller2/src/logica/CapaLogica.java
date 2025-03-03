package logica;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import logica.boleto.*;
import logica.excepciones.*;
import logica.minivan.*;
import logica.paseo.*;
import logica.valueObjects.*;
import persistencia.Persistencia;

public class CapaLogica extends UnicastRemoteObject implements ICapaLogica
{
	
	
	private static final long serialVersionUID = 1L;
	private Paseos paseos;
	private Minivanes minivanes;
	private Monitor monitor;
	
	public CapaLogica() throws RemoteException
	{
		paseos = new Paseos();
		minivanes = new Minivanes();
		monitor = Monitor.getInstancia();
		
		try
		{
			this.cargarDatos();
		}finally
		{
			
		}
	
	}
	
	//Registra una nueva minivan
	public void registroMinivan(VOIngresoMinivan mini) throws MinivanYaExisteException, CantAsientosIncorrectaException, RemoteException
	
	{
		if(mini.getCantAsientos() <= 0)
		{
			throw new CantAsientosIncorrectaException("La cantidad de asientos debe ser mayor a 0");
		}
		
		monitor.comienzoLectura();
		
		if(minivanes.member(mini.getMatricula()))
		{
			monitor.terminoLectura();
			throw new MinivanYaExisteException("La minivan ya se encuentra registrada");
		}
		
		
		Minivan aux = new Minivan(mini.getMatricula(), mini.getMarca(), mini.getModelo(), mini.getCantAsientos());
		
		monitor.terminoLectura();
		monitor.comienzoEscritura();
		
		minivanes.insert(aux);
		
		monitor.terminoEscritura();
		
		
	}
	
	//Devuelve un listado de todas las minivanes registradas
	public VOMinivan [] listadoMinivanes() throws RemoteException
	{
		monitor.comienzoLectura();
		VOMinivan [] aux = minivanes.listarMinivanes();
		monitor.terminoLectura();
		
		return aux;
	}
	
	//Registra un nuevo paseo
	public void registroPaseo(VOIngresoPaseo pa) throws PrecioMenorA0Exception, PaseoYaExisteException, NoHayMiniDisponibleException, RemoteException 
	{
		
		
		if(pa.getPrecioBase() < 1)
		{
			throw new PrecioMenorA0Exception("El precio base debe ser mayor a 0");
		}
		
		monitor.comienzoLectura();
		
		if(paseos.member(pa.getCodigo()))
		{
			throw new PaseoYaExisteException("El codigo de paseo ya existe");
		}
		
		Minivan mini = minivanes.primeraDisponible(pa.getHoraSalida(), pa.getHoraLlegada());
		
		if(mini == null)
		{
			monitor.terminoLectura();
			throw new NoHayMiniDisponibleException("No hay minivan disponible para ese horario");
		}
		
		
		
		Paseo paseo = new Paseo(pa.getCodigo(), pa.getDestino(), pa.getHoraLlegada(), pa.getHoraSalida(), pa.getPrecioBase(), mini.getCantAsientos());
		
		monitor.terminoLectura();
		monitor.comienzoEscritura();
		
		paseos.insert(paseo);
		mini.agregarPaseo(paseo);
		
		monitor.terminoEscritura();
	}
	
	//Devuelve todos los paseos de una minivan
	public VOPaseo [] listadoPaseosMinivan(String matricula) throws MinivanNoExisteException, RemoteException
	{
		
		monitor.comienzoLectura();
		
		if(!minivanes.member(matricula))
		{
			monitor.terminoLectura();
			throw new MinivanNoExisteException("No hay minivan registrada con esa matricula");
		}
		
		int aux = minivanes.find(matricula).getPaseosAasignados().largo();
		
		VOPaseo [] resu = new VOPaseo[aux];
		
		resu = minivanes.find(matricula).listarPaseos();
		
		monitor.terminoLectura();
		
		return resu;
		
		
	}
	
	//Devuelve todos los paseos con el destino indicado
	public VOPaseo[] listarPaseosDestino(String destino) throws NoHayConDestinoException, RemoteException
	{
		monitor.comienzoLectura();
		if(paseos.listarPaseosDestino(destino).length == 0)
		{
			monitor.terminoLectura();
			throw new NoHayConDestinoException("No hay paseos con ese destino");
		}
		
		VOPaseo [] resu = paseos.listarPaseosDestino(destino);
		
		monitor.terminoLectura();
		
		return resu;
	}
	
	//Devuelve un listado con por lo menos la cantida de boletos ingresada disponibles
	public VOPaseo [] listadoPaseosBoletosDisponibles(int cant) throws NoHayConBoletosException, RemoteException
	{
		monitor.comienzoLectura();
		
		if(paseos.listarPaseosBoletosDispoibles(cant).length == 0)
		{
			monitor.terminoLectura();
			throw new NoHayConBoletosException("No hay paseos con esa cantidad de boletos disponibles");
		}
		
		VOPaseo[] resu = paseos.listarPaseosBoletosDispoibles(cant);
		
		monitor.terminoLectura();
		
		return resu;
	}
	
	//Registra un boleto en el paseo
	public void ventaBoleto(String codigo, VOIngresoBoleto bol) throws PaseoNoExisteException, SinBoletosDispoiblesException, EdadInvalidaException, CelularInvalidoException, RemoteException
	{
		
		if(bol.getNumeroCelular() <1)
		{
			throw new CelularInvalidoException("EL numero de celular debe ser mayor a 0");
		}
		
		if(bol.getEdadPasajero() < 0)
		{
			throw new EdadInvalidaException("La edad debe ser mayor o igual a 0");
		}
		
		monitor.comienzoLectura();
		
		if(!paseos.member(codigo))
		{
			monitor.terminoLectura();
			throw new PaseoNoExisteException("El paseo no existe");
		}
		
		Paseo paseo = paseos.find(codigo);
		
		if(paseo.disponibles() <= 0)
		{
			monitor.terminoLectura();
			throw new SinBoletosDispoiblesException("No hay boletos dispoibles para el paseo");
		}
	
		int numBol = paseo.largoBoletos() + 1;
		Boleto aux;
		
		if(bol.getDescuento() > 0)
		{
			 aux = new Especial(numBol, bol.getNombrePasajero(), bol.getEdadPasajero(), bol.getNumeroCelular(), bol.getDescuento());
		}else
		{
			 aux = new Boleto(numBol, bol.getNombrePasajero(), bol.getEdadPasajero(), bol.getNumeroCelular());
		}
		
		monitor.terminoLectura();
		monitor.comienzoEscritura();
		
		paseo.insertarBoleto(aux);
		
		monitor.terminoEscritura();
		
	}
	
	//Devuelve un listado de boletos vendidos para el paseo ingresado
	public VOBoleto[] listadoBoletosVendidos(String codigo, boolean especial) throws PaseoNoExisteException, NoHayVendidosException, RemoteException
	{
		
		monitor.comienzoLectura();
		
		if(!paseos.member(codigo))
		{
			monitor.terminoLectura();
			throw new PaseoNoExisteException("El paseo no existe");
		}
		if(paseos.find(codigo).getBoletosComprados().listadoPorTipo(especial).length == 0)
		{
			monitor.terminoLectura();
			throw new NoHayVendidosException("No hay boletos de ese tipo vendidos para ese paseo");
		}
		
		VOBoleto [] resu = paseos.find(codigo).getBoletosComprados().listadoPorTipo(especial);
		
		monitor.terminoLectura();
		
		return resu;
	}
	
	//Devuelve el monto recaudado para el paseo
	public double montoRecaudadoPaseo(String codigo) throws PaseoNoExisteException, RemoteException
	{
		monitor.comienzoLectura();
		
		if(!paseos.member(codigo))
		{
			throw new PaseoNoExisteException("El paseo no existe");
		}
		
		double resu = paseos.find(codigo).contarRecaudado();
		
		monitor.terminoLectura();
		
		return resu;
		
		
	}
	
	//Guarda los datos del sistema
	public void guardarDatos() throws RemoteException
	{
		Persistencia file = new Persistencia();
		
		monitor.comienzoLectura();
		try
		{
			file.respaldar("Backup", paseos, minivanes);
		}
		catch(PersistenciaException e)
		{
			monitor.terminoLectura();
			System.out.println("\n" + e.darMensaje());
		}finally
		{
			monitor.terminoLectura();
		}
		
		
		
	}
	
	public void cargarDatos() throws RemoteException
	{
		Persistencia file = new Persistencia();
		
		monitor.comienzoEscritura();
		try
		{
			Object[] datos = file.recuperar("Backup");
			
			paseos = (Paseos) datos[0];
			minivanes = (Minivanes) datos[1];
		}
		catch (PersistenciaException e) 
		{
			monitor.terminoEscritura();
			System.out.println("\n" + e.darMensaje());
		}
		catch (ClassNotFoundException e) 
		{
			monitor.terminoEscritura();
			System.out.println("\n" + e.getMessage());
		}finally
		{
			monitor.terminoEscritura();
		}
		
	}
}