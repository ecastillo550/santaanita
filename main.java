import java.io.*;
import java.text.*;

class Santaanita {
	public static void main(String args[]) {
		System.out.println("Bienvenido al sistema de administracion de Santa anita");
		char userInput; //Variable dedicada a tener el input del usuario
		String database[][] = new String[20][13]; //estructura de datos con la infromacion de las casas (12 meses y el apellido)
		String mesesString[] = new String[] {"Enero", "Febero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

		do { //ciclo de ejecucion del programa
			System.out.println("escriba 'm' para ver el menu o 'q' para salir");
			userInput = Lectura.readChar();

			switch (userInput) {
				case 'm':
					System.out.println(getMenu());
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
					reporteAnual(database, mesesString);
					break;

				case '2':
					System.out.println("escribe el numero de casa que desea ver:");
					reporteFamilia(database, Lectura.readInt(), mesesString);
					break;

				default:
					System.out.println(getMenu());
					break;
			}
		} while (userInput != 'q');
	}

	public static String getMenu() {
		String menu;

		menu = "Dar de alta informacion: a\n";
		menu += "Reporte anual: 1\n";

		return menu;
	}

	public static void reporteAnual(String database[][], String mesesString[]) {
		for (int casa = 0; casa < 20 ; casa++) {
			for (int mes = 0; mes <= 12 ; mes++) {
				if (mes == 0) {
					System.out.println("\nFamilia: " + database[casa][mes]);
				} else {
					System.out.println(mesesString[mes-1] + "\t \t$" + database[casa][mes]);
				}
			}
		}
	}

	public static void reporteFamilia(String database[][], int casa, String mesesString[]) {
		for (int mes = 0; mes <= 12 ; mes++) {
			if (mes == 0) {
				System.out.println("\nFamilia: " + database[casa][mes]);
			} else {
				System.out.println(mesesString[mes-1] + "\t \t$" + database[casa][mes]);
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
					database[casa][mes] = "0";
				}
			}
		}
	}

	// public static void cargarMeses(String mesesString[]) {
	// 	mesesString[0] = "Enero";
	// 	mesesString[1] = "Febrero";
	// 	mesesString[2] = "Marzo";
	// 	mesesString[3] = "Enero";
	// 	mesesString[4] = "Enero";
	// 	mesesString[5] = "Enero";
	// 	mesesString[6] = "Enero";
	// 	mesesString[7] = "Enero";
	// 	mesesString[8] = "Enero";
	// 	mesesString[9] = "Enero";
	// 	mesesString[10] = "Enero";
	// 	mesesString[11] = "Enero";
	// }
}

