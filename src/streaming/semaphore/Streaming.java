package streaming.semaphore;

import java.util.concurrent.Semaphore;

public class Streaming extends Thread {

	private String nombre;
	Semaphore limitadorPantallas = new Semaphore(3);

	public Streaming(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {

		for (int i = 1; i <= 10; i++) {

			Usuario usuario = new Usuario("Usuario:" + i, this);
			usuario.start();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void ver() {
		try {
			limitadorPantallas.acquire();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cerrarSesion() {
		limitadorPantallas.release();
	}
}
