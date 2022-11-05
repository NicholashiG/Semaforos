package database;

public class GestorIngresos {

	int numeroVistasDisponibles = 0;
	int numeroPersonasViendo = 0;
	int numeroEditoresDisponibles = 1;
	int numeroEditoresEditando = 0;

	public GestorIngresos(int vistas) {
		this.numeroVistasDisponibles = vistas;
	}

	public synchronized void visualizar() throws InterruptedException {

		while (numeroPersonasViendo == numeroVistasDisponibles) {
			System.out.println("El " + Thread.currentThread().getName() + " está esperando para ver");
			wait();
		}
		numeroPersonasViendo++;
		notify();
	}

	public synchronized void editar() throws InterruptedException {

		while (numeroEditoresEditando == numeroEditoresDisponibles) {
			System.out.println("El " + Thread.currentThread().getName() + " está esperando para editar");
			wait();
		}
		numeroEditoresEditando++;
		notify();
	}

	public synchronized void salirUsr() throws InterruptedException {
		while (numeroPersonasViendo == 0) {
			wait();
		}
		numeroPersonasViendo--;
		notify();
	}

	public synchronized void salirEdit() throws InterruptedException {
		while (numeroEditoresEditando == 0) {
			wait();
		}
		numeroEditoresEditando--;
		notify();
	}

	public int getNumeroVistasDisponibles() {
		return numeroVistasDisponibles;
	}

	public void setNumeroVistasDisponibles(int numeroVistasDisponibles) {
		this.numeroVistasDisponibles = numeroVistasDisponibles;
	}

	public int getNumeroPersonasViendo() {
		return numeroPersonasViendo;
	}

	public void setNumeroPersonasViendo(int numeroPersonasViendo) {
		this.numeroPersonasViendo = numeroPersonasViendo;
	}

	public int getNumeroEditoresDisponibles() {
		return numeroEditoresDisponibles;
	}

	public void setNumeroEditoresDisponibles(int numeroEditoresDisponibles) {
		this.numeroEditoresDisponibles = numeroEditoresDisponibles;
	}

	public int getNumeroEditoresEditando() {
		return numeroEditoresEditando;
	}

	public void setNumeroEditoresEditando(int numeroEditoresEditando) {
		this.numeroEditoresEditando = numeroEditoresEditando;
	}

}
