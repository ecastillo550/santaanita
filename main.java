import java.io.*;
import java.text.*;

class Santaanita {
	public static void main(String args[]) {
		System.out.println("Bienvenido al sistema de administracion de Santa anita");
		char userInput;//Variable dedicada a tener el input del usuario

		do { //ciclo de ejecucion del programa
			System.out.println("escriba 'm' para ver el menu o 'q' para salir");
			userInput = Lectura.readChar();

			switch (userInput) {
				case 'm':
					getMenu();
					break;

				case 'q':
					System.out.println("Hasta luego");
					break;

				default:
					getMenu();
					break;
			}
		} while (userInput != 'q');
	}

	public static void getMenu() {
		System.out.println("run");
	}
}

