package logica;

import java.rmi.*;

import logica.excepciones.*;
import logica.valueObjects.*;

public interface ICapaLogica extends Remote{
	
	//Registra una nueva minivan
	public void registroMinivan(VOIngresoMinivan mini) throws MinivanYaExisteException, CantAsientosIncorrectaException, RemoteException;
	
	//Devuelve un listado de todas las minivanes registradas
	public VOMinivan [] listadoMinivanes() throws RemoteException;
	
	//Registra un nuevo paseo
	public void registroPaseo(VOIngresoPaseo pa) throws PrecioMenorA0Exception, PaseoYaExisteException, NoHayMiniDisponibleException, RemoteException;
	
	//Devuelve todos los paseos de una minivan
	public VOPaseo [] listadoPaseosMinivan(String matricula) throws MinivanNoExisteException, RemoteException;
	
	//Devuelve todos los paseos con el destino indicado
	public VOPaseo[] listarPaseosDestino(String destino) throws NoHayConDestinoException, RemoteException;
	
	//Devuelve un listado con por lo menos la cantida de boletos ingresada disponibles
	public VOPaseo [] listadoPaseosBoletosDisponibles(int cant) throws NoHayConBoletosException, RemoteException;
	
	//Registra un boleto en el paseo
	public void ventaBoleto(String codigo, VOIngresoBoleto bol) throws PaseoNoExisteException, SinBoletosDispoiblesException, EdadInvalidaException, CelularInvalidoException, RemoteException;
	
	//Devuelve un listado de boletos vendidos para el paseo ingresado
	public VOBoleto[] listadoBoletosVendidos(String codigo, boolean especial) throws PaseoNoExisteException, NoHayVendidosException, RemoteException;
	
	//Devuelve el monto recaudado para el paseo
	public double montoRecaudadoPaseo(String codigo) throws PaseoNoExisteException, RemoteException;
	
	//Guarda los datos del sistema
	public void guardarDatos() throws RemoteException;
	
	//Carga los datos del sistema
	public void cargarDatos() throws RemoteException;

}
