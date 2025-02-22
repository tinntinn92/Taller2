
import java.time.LocalTime;

import logica.CapaLogica;
import logica.valueObjects.*;
import logica.excepciones.*;

public class Principal {

	public static void main(String[] args) {
		
		CapaLogica fachada = new CapaLogica();
		VOIngresoMinivan mini = new VOIngresoMinivan("A5", "Ford", "Ecosport", 20);
		VOIngresoPaseo pas = new VOIngresoPaseo("PDE001", "Punta del este", LocalTime.of(16, 00), LocalTime.of(18, 00), 200);
		VOIngresoBoleto bol = new VOIngresoBoleto(1, "Pepe", 22, 10, 0, "PDE001");
		
		fachada.cargarDatos();

		
		try
		{
			fachada.registroMinivan(mini);
		}
		catch(CantAsientosIncorrectaException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		catch(MinivanYaExisteException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		
		
		System.out.println("\n" + fachada.listadoMinivanes()[0].getCantAsientos());

		try
		{
			fachada.registroPaseo(pas);
		}
		catch(PaseoYaExisteException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		catch(PrecioMenorA0Exception e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		catch(NoHayMiniDisponibleException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		
	
		
		try
		{
			System.out.println("\n" + fachada.listadoPaseosMinivan("ASE105")[0].getDestino());
		}
		catch(MinivanNoExisteException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		
		
		try
		{
			System.out.println("\n" + fachada.listarPaseosDestino("Punta del este")[0].getCodigo());
		}
		catch(NoHayConDestinoException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		
		try
		{
			System.out.println("\n" + fachada.listadoPaseosBoletosDisponibles(1)[0].getPrecioBase());
		}
		catch(NoHayConBoletosException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		
		try
		{
			System.out.println("\n" + fachada.listarPaseosDestino("Punta del este")[0].getBoletosDispoibles());
		}
		catch(NoHayConDestinoException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
			
		try
		{
			fachada.ventaBoleto(pas.getCodigo(), bol);
		}
		catch(PaseoNoExisteException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		catch(SinBoletosDispoiblesException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		catch(EdadInvalidaException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		catch(CelularInvalidoException e)
		{
			System.out.println("\n" + e.darMensaje());
		}

		try
		{
			System.out.println("\n" + fachada.listarPaseosDestino("Punta del este")[0].getBoletosDispoibles());
		}
		catch(NoHayConDestinoException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		
		try
		{
			System.out.println("\n" + fachada.listadoBoletosVendidos(bol.getCodigoPaseo(), true)[0].getDescuento());
		}
		catch(PaseoNoExisteException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		catch(NoHayVendidosException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		
		try
		{
			System.out.println("\n se recaudo " + fachada.montoRecaudadoPaseo(bol.getCodigoPaseo()));
		}
		catch(PaseoNoExisteException e)
		{
			System.out.println("\n" + e.darMensaje());
		}
		
		fachada.guardarDatos();

		
		
	}

}
