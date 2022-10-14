package p06.CarreraCaballos;

public class CarreraCaballos {
	public static void main(String[] args) {
		Caballo [] miCaballo = new Caballo[10];
		int j;
		
		//Creamos los hilos
		for (int i=0; i < miCaballo.length; i++) {
			miCaballo[i] = new Caballo(i);
		}	
		//Lanzamos la carrera
		for (int i=0; i < miCaballo.length; i++) {
			miCaballo[i].start();
		}
		//Los ponemos a correr
		Caballo.iniciarCarrera();
		
		//Esperamos que todos los caballos terminen
		for (int i=0; i < miCaballo.length; i++) {
			if (miCaballo[i].isAlive()) {
				try {
					miCaballo[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("La carrera ha terminado");
		System.out.println("El ganador es "+Caballo.getCaballoGanador());
	}
	
}
