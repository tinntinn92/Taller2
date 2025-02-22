package logica;


import java.io.Serializable;

import logica.boleto.*;
import logica.excepciones.*;
import logica.minivan.*;
import logica.paseo.*;
import logica.valueObjects.*;

public class CapaLogica implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Paseos paseos;
	private Minivanes minivanes;
	
	public CapaLogica()
	{
		paseos = new Paseos();
		minivanes = new Minivanes();
	}
	
	//Registra una nueva minivan
	public void registroMinivan(VOIngresoMinivan mini) throws MinivanYaExisteException, CantAsientosIncorrectaException
	{
		if(mini.getCantAsientos() <= 0)
		{
			throw new CantAsientosIncorrectaException("La cantidad de asientos debe ser mayor a 0");
		}
		
		if(minivanes.member(mini.getMatricula()))
		{
			throw new MinivanYaExisteException("La minivan ya se encuentra registrada");
		}
		
		
		Minivan aux = new Minivan(mini.getMatricula(), mini.getMarca(), mini.getModelo(), mini.getCantAsientos());
		
		minivanes.insert(aux);
	}
	
	//Devuelve un listado de todas las minivanes registradas
	public VOMinivan [] listadoMinivanes()
	{
		return minivanes.listarMinivanes();
	}
	
	//Registra un nuevo paseo
	public void registroPaseo(VOIngresoPaseo pa) throws PrecioMenorA0Exception, PaseoYaExisteException, NoHayMiniDisponibleException
	{
		
		
		if(pa.getPrecioBase() < 1)
		{
			throw new PrecioMenorA0Exception("El precio base debe ser mayor a 0");
		}

		if(paseos.member(pa.getCodigo()))
		{
			throw new PaseoYaExisteException("El codigo de paseo ya existe");
		}
		
		Minivan mini = minivanes.primeraDisponible(pa.getHoraSalida(), pa.getHoraLlegada());
		
		if(mini == null)
		{
			throw new NoHayMiniDisponibleException("No hay minivan disponible para ese horario");
		}
		
		
		
		Paseo paseo = new Paseo(pa.getCodigo(), pa.getDestino(), pa.getHoraLlegada(), pa.getHoraSalida(), pa.getPrecioBase(), mini.getCantAsientos());
		
		paseos.insert(paseo);
		mini.agregarPaseo(paseo);
	}
	
	//Devuelve todos los paseos de una minivan
	public VOPaseo [] listadoPaseosMinivan(String matricula) throws MinivanNoExisteException
	{
		if(!minivanes.member(matricula))
		{
			throw new MinivanNoExisteException("No hay minivan registrada con esa matricula");
		}
		
		int aux = minivanes.find(matricula).getPaseosAasignados().largo();
		
		VOPaseo [] resu = new VOPaseo[aux];
		
		resu = minivanes.find(matricula).listarPaseos();
		
		return resu;
		
		
	}
	
	//Devuelve todos los paseos con el destino indicado
	public VOPaseo[] listarPaseosDestino(String destino) throws NoHayConDestinoException
	{
		if(paseos.listarPaseosDestino(destino).length == 0)
		{
			throw new NoHayConDestinoException("No hay paseos con ese destino");
		}
		
		return paseos.listarPaseosDestino(destino);
	}
	
	//Devuelve un listado con por lo menos la cantida de boletos ingresada disponibles
	public VOPaseo [] listadoPaseosBoletosDisponibles(int cant) throws NoHayConBoletosException
	{
		if(paseos.listarPaseosBoletosDispoibles(cant).length == 0)
		{
			throw new NoHayConBoletosException("No hay paseos con esa cantidad de boletos disponibles");
		}
		
		return paseos.listarPaseosBoletosDispoibles(cant);
	}
	
	//Registra un boleto en el paseo
	public void ventaBoleto(String codigo, VOIngresoBoleto bol) throws PaseoNoExisteException, SinBoletosDispoiblesException, EdadInvalidaException, CelularInvalidoException
	{
		if(!paseos.member(codigo))
		{
			throw new PaseoNoExisteException("El paseo no existe");
		}
		
		Paseo paseo = paseos.find(codigo);
		
		if(paseo.disponibles() <= 0)
		{
			throw new SinBoletosDispoiblesException("No hay boletos dispoibles para el paseo");
		}
		
		if(bol.getEdadPasajero() < 0)
		{
			throw new EdadInvalidaException("La edad debe ser mayor o igual a 0");
		}
		
		if(bol.getNumeroCelular() <1)
		{
			throw new CelularInvalidoException("EL numero de celular debe ser mayor a 0");
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
		
		paseo.insertarBoleto(aux);
			
		
	}
	
	//Devuelve un listado de boletos vendidos para el paseo ingresado
	public VOBoleto[] listadoBoletosVendidos(String codigo, boolean especial) throws PaseoNoExisteException, NoHayVendidosException
	{
		if(!paseos.member(codigo))
		{
			throw new PaseoNoExisteException("El paseo no existe");
		}
		if(paseos.find(codigo).getBoletosComprados().listadoPorTipo(especial).length == 0)
		{
			throw new NoHayVendidosException("No hay boletos de ese tipo vendidos para ese paseo");
		}
		
		return paseos.find(codigo).getBoletosComprados().listadoPorTipo(especial);
	}
	
	//Devuelve el monto recaudado para el paseo
	public double montoRecaudadoPaseo(String codigo) throws PaseoNoExisteException
	{
		if(!paseos.member(codigo))
		{
			throw new PaseoNoExisteException("El paseo no existe");
		}
		
		return paseos.find(codigo).contarRecaudado();
		
		
	}

}
