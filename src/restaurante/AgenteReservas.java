package restaurante;


public class AgenteReservas {

	int numeroReservasDisponibles = 0;
	int numeroReservasSolicitadas = 0;

	public AgenteReservas(int aforo) {
		this.numeroReservasDisponibles = aforo;
	}


	public synchronized void reservar() throws InterruptedException{

		while(numeroReservasSolicitadas == numeroReservasDisponibles){
			System.out.println("El "+Thread.currentThread().getName()+" está esperando");
			wait();
		}
		numeroReservasSolicitadas++;
		notify();
	}

	public synchronized void cancelarReserva() throws InterruptedException{
		while(numeroReservasSolicitadas == 0){
			wait();
		}
		numeroReservasSolicitadas--;
		notify();
	}




}
