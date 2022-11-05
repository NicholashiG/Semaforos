package database;

public class Database {

	private String nombre;
	GestorIngresos gestorIngresos;

	public Database(String nombre, int cantidadVisualizadores) {
		this.nombre = nombre;
		this.gestorIngresos = new GestorIngresos(cantidadVisualizadores);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void visualizar() {
		try {
			gestorIngresos.visualizar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void editar() {

		try {
			gestorIngresos.editar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void salirUsr() {

		try {
			gestorIngresos.salirUsr();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void salirEdit() {

		try {
			gestorIngresos.salirEdit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void simularUsuarios() {

		Usuario usuario = null;
		for (int i = 1; i <= 10; i++) {
			if (i == 4 || i == 5) {
				usuario = new Usuario("editor " + i, this, 1);
			} else {
				usuario = new Usuario("usuario " + i, this, (int) Math.random());
			}
			usuario.start();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
