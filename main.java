import java.io.*;
import java.text.*;

class Santaanita {
	public static void main(String args[]) {
		System.out.println("Bienvenido al sistema de administracion de Santa anita");
		char userInput; //Variable dedicada a tener el input del usuario
		String database[][] = new String[20][13]; //estructura de datos con la infromacion de las casas (12 meses y el apellido)
		String mesesString[] = new String[] {"Enero", "Febero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

		int casa;
		int mes;

		cargarDatosDummy(database);
		do { //ciclo de ejecucion del programa
			System.out.println("escriba 'm' para ver el menu o 'q' para salir");
			//System.out.println(getMenu());
			userInput = Lectura.readChar();

			switch (userInput) {
				case 'm':
					System.out.println(getMenu());
					break;

				case 'q':
					System.out.println("Hasta luego");
					break;

				case 'a':
					System.out.println("escribe el numero de casa:");
					casa = Lectura.readInt();
					System.out.println("escribe el mes que desea ingresar: \n13 para ingresar toda la informacion de la familia\n 0 para ingresar el nombre de la familia");
					mes = Lectura.readInt();
					if (mes == 13) {
						cargarFamilia(database, casa, mesesString);
					} else if(mes == 0) {
						cargarNombreFamilia(database, casa, mes);
					} else if(mes > 0 && mes <= 12) {
						cargarMesFamilia(database, casa, mes, mesesString);
					}else {
						System.out.println("Mes invalido");
					}

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
		menu += "Reporte por familia: 2\n";

		menu += "Terminar el programa: q\n";

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

	public static void cargarFamilia(String database[][], int casa, String mesesString[]) {
		for (int mes = 0; mes <= 12 ; mes++) {
			if (mes == 0) {
				System.out.print("Ingrese el nombre de la familia: ");
				database[casa][mes] = Lectura.readString();
			} else {
				System.out.print("Ingrese el monto pagado en " + mesesString[mes-1] + ": " );
				database[casa][mes] = Lectura.readString();
			}
		}
	}

	public static void cargarMesFamilia(String database[][], int casa, int mes, String mesesString[]) {
			System.out.print("Ingrese el monto pagado en " + mesesString[mes-1] + ": " );
			database[casa][mes] = Lectura.readString();
	}

	public static void cargarNombreFamilia(String database[][], int casa, int mes) {
			System.out.print("Ingrese el nombre de la familia: ");
			database[casa][mes] = Lectura.readString();
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
}

