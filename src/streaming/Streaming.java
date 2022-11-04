package streaming;

public class Streaming {

	private String nombre;
	LimitadorPantallas limitadorPantallas;

	public Streaming(String nombre, int limite) {
		this.nombre = nombre;
		this.limitadorPantallas = new LimitadorPantallas(limite);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void ver() {
		try {
			limitadorPantallas.ver();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void cerrarSesion() {

		try {
			limitadorPantallas.cerrarSesion();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void simularUsuarios() {

		Usuario usuario = null;
		for (int i = 1; i <= 10; i++) {
			usuario = new Usuario("usuario " + i, this);
			usuario.start();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
