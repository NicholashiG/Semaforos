package streaming;

public class LimitadorPantallas {

	int numeroPantallasDisponibles = 0;
	int numeroPantallasUsadas = 0;

	public LimitadorPantallas(int cantidad) {
		this.numeroPantallasDisponibles = cantidad;
	}

	public synchronized void ver() throws InterruptedException {

		while (numeroPantallasUsadas == numeroPantallasDisponibles) {
			System.out.println(
					"El " + Thread.currentThread().getName() + " está esperando a la desconexión de una pantalla");
			wait();
		}
		numeroPantallasUsadas++;
		notify();
	}

	public synchronized void cerrarSesion() throws InterruptedException {
		while (numeroPantallasUsadas == 0) {
			wait();
		}
		numeroPantallasUsadas--;
		notify();
	}

	public int getNumeroPantallasDisponibles() {
		return numeroPantallasDisponibles;
	}

	public int getNumeroPantallasUsadas() {
		return numeroPantallasUsadas;
	}

}
