package database;

public class Usuario extends Thread {

	private String nombre;
	Database db;
	int accion;

	public Usuario(String nombre, Database db, int accion) {
		super(nombre);
		this.nombre = nombre;
		this.db = db;
		this.accion = accion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAccion() {
		return accion;
	}

	public void setAccion(int accion) {
		this.accion = accion;
	}

	@Override
	public void run() {

		if (accion == 0) {
			db.visualizar();
			System.out.println("El " + getNombre() + " está viendo la base de datos "
					+ db.gestorIngresos.numeroPersonasViendo + ":" + db.gestorIngresos.numeroVistasDisponibles);
			try {
				Thread.sleep(20000);

				db.salirUsr();
				System.out.println("El " + getNombre() + " salió de la base de datos "
						+ db.gestorIngresos.numeroPersonasViendo + ":" + db.gestorIngresos.numeroVistasDisponibles);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			db.editar();
			System.out.println("El " + getNombre() + " está editando la base de datos "
					+ db.gestorIngresos.numeroEditoresEditando + ":" + db.gestorIngresos.numeroEditoresDisponibles);
			try {
				Thread.sleep(10000);

				db.salirEdit();
				System.out.println("El " + getNombre() + " salió de la edición de la base de datos "
						+ db.gestorIngresos.numeroEditoresEditando + ":" + db.gestorIngresos.numeroEditoresDisponibles);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
