import java.io.*;
import java.text.*;

class Santaanita {
	public static void main(String args[]) {
		System.out.println("Bienvenido al sistema de administracion de Santa anita");
		char userInput; //Variable dedicada a tener el input del usuario
		String database[][] = new String[20][13]; //estructura de datos con la infromacion de las casas (12 meses y el apellido)

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

				case 'a':
					System.out.println("Alta de info");
					break;

				case 'l':
					cargarDatosDummy(database);
					break;

				case '1':
					reporteAnual(database);
					break;

				default:
					getMenu();
					break;
			}
		} while (userInput != 'q');
	}

	public static void getMenu() {
		System.out.println("Dar de alta informacion: a");
		System.out.println("Reporte anual: 1");
	}

	public static void reporteAnual(String database[][]) {
		for (int casa = 0; casa < 20 ; casa++) {
			for (int mes = 0; mes <= 12 ; mes++) {
				System.out.println(database[casa][mes]);
			}
		}
	}

	public static void cargarDatosDummy(String database[][]) {
		database[0][0] = "familia";

		for (int casa = 0; casa < 20 ; casa++) {
			for (int mes = 0; mes <= 12 ; mes++) {
				if (mes == 0) {
					database[casa][mes] = "familia " + casa;
				} else {
					database[casa][mes] = "100";
				}
			}
		}
	}
}

