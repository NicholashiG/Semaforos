package streaming;

public class Usuario extends Thread {

	private String nombre;
	Streaming streamingService;

	public Usuario(String nombre, Streaming streamingService) {
		super(nombre);
		this.nombre = nombre;
		this.streamingService = streamingService;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {

		streamingService.ver();
		System.out.println("El " + getNombre() + " está usando una pantalla "
				+ streamingService.limitadorPantallas.numeroPantallasUsadas + ":"
				+ streamingService.limitadorPantallas.numeroPantallasDisponibles);
		try {
			Thread.sleep(10000);

			streamingService.cerrarSesion();
			System.out.println("El " + getNombre() + " dejó de usar una pantalla "
					+ streamingService.limitadorPantallas.numeroPantallasUsadas + ":"
					+ streamingService.limitadorPantallas.numeroPantallasDisponibles);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
