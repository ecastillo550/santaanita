import java.io.*;
import java.text.*;
import java.util.Date;

class Santaanita {
	public static void main(String args[]) {
		System.out.println("Bienvenido al sistema de administracion de Santa anita");
		char userInput; //Variable dedicada a tener el input del usuario
		String database[][] = new String[20][13]; //estructura de datos con la infromacion de las casas (12 meses y el apellido)
		String mesesString[] = new String[] {"Enero", "Febero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

		int familia=0;
		int mes=0;
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
					System.out.println("escribe el numero de familia:");
					familia = Lectura.readInt();
					System.out.println("escribe el mes que desea ingresar: \n13 para ingresar toda la informacion de la familia\n 0 para ingresar el nombre de la familia");

					mes = Lectura.readInt();
					if (mes == 13) {
						cargarFamilia(database, familia, mesesString);
					} else if(mes == 0) {
						cargarNombreFamilia(database, familia, mes);
					} else if(mes > 0 && mes <= 12) {
						cargarMesFamilia(database, familia, mes, mesesString);
					}else {
						System.out.println("Mes invalido");
					}

					break;

				case '1':
					reporteAnual(database, mesesString);
					break;

				case '2':
					reporteFamilia(database, mesesString);
					break;

				case '3':
					deudaFamilia(database, familia);
					break;

				case '4':
					montoAnio(database, familia, mes);
					break;

				case '5':
					montoMes(database, familia, mes);
					break;

				case '6':
					deudaMontoAnio(database, familia, mes);
					break;

				case '7':
					deudaMontoMes(database, familia, mes);
					break;

				case '8':
					montoActual(database, familia, mes);
					break;

				case '9':
					deudaFamilias(database);
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
		menu+= "Reporte anual: 1\n";
		menu+= "Reporte por familia: 2\n";
		menu+="Deuda por Familia: 3\n";
		menu+="Monto recaudado en el año: 4\n";
		menu+="Monto recaudado en el mes: 5\n";
		menu+="Deuda total del año: 6\n";
		menu+="Deuda total del mes: 7\n";
		menu+="Monto pagado a la fecha por familia: 8\n";

		menu+="Familias con deuda: 9\n";
		menu+="Corte del ano: 0\n";


		menu += "Terminar el programa: q\n";

		return menu;
	}

	public static void reporteAnual(String database[][], String mesesString[]) {
		for (int familia = 0; familia < 20 ; familia++) {
			for (int mes = 0; mes <= 12 ; mes++) {
				if (mes == 0) {
					System.out.println("\nFamilia: " + database[familia][mes]);
				} else {
					System.out.println(mesesString[mes-1] + "\t \t$" + database[familia][mes]);

				}
			}
		}
		java.util.Date fecha = new Date();
		System.out.println("\n\t"+fecha);
	}

	public static void reporteFamilia(String database[][], String mesesString[]) {
		System.out.println("escribe el numero de familia que desea ver:");
		int familia=Lectura.readInt();
		for (int mes = 0; mes <= 12 ; mes++) {
			if (mes == 0) {
				System.out.println("\nFamilia: " + database[familia][mes]);
			} else {
				System.out.println(mesesString[mes-1] + "\t \t$" + database[familia][mes] + "\t deuda: " + (9500 -  Double.parseDouble(database[familia][mes])));
			}
		}
		java.util.Date fecha = new Date();
		System.out.println("\n\t"+fecha);
	}


	public static void cargarFamilia(String database[][], int familia, String mesesString[]) {
		for (int mes = 0; mes <= 12 ; mes++) {
			if (mes == 0) {
				System.out.print("Ingrese el nombre de la familia: ");
				database[familia][mes] = Lectura.readString();
			} else {
				System.out.print("Ingrese el monto pagado en " + mesesString[mes-1] + ": " );
				database[familia][mes] = Lectura.readString();
			}
		}
		java.util.Date fecha = new Date();
		System.out.println("\n\t"+fecha);
	}

	public static void cargarMesFamilia(String database[][], int familia, int mes, String mesesString[]) {
		System.out.print("Ingrese el monto pagado en " + mesesString[mes-1] + ": " );
		database[familia][mes] = Lectura.readString();
	}

	public static void cargarNombreFamilia(String database[][], int familia, int mes) {
		System.out.print("Ingrese el nombre de la familia: ");
		database[familia][mes] = Lectura.readString();
	}

	public static void cargarDatosDummy(String database[][]) {
		database[0][0] = "familia";

		for (int familia = 0; familia < 20 ; familia++) {
			for (int mes = 0; mes <= 12 ; mes++) {
				if (mes == 0) {
					database[familia][mes] = "familia " + familia;
				} else {
					database[familia][mes] = "0";
				}
			}
		}
	}

	public static void deudaFamilias(String database[][]){
		double deuda=0;
		for(int familia=0;familia<20;familia++) {
			deuda=0;
			for(int mes=1;mes<13;mes++) {
				if(Double.parseDouble(database[familia][mes])<9500)
				deuda+= (9500-Double.parseDouble(database[familia][mes]));
			}
			System.out.println("La deuda de la familia "+database[familia][0]+" es "+deuda);
		}
		java.util.Date fecha = new Date();
		System.out.println("\n\t"+fecha);
	}

	public static void deudaFamilia(String database[][],int familia){
		System.out.println("escribe el numero de familia que desea ver:");
		familia=Lectura.readInt();
		double deuda=0;
		for(int mes=1;mes<13;mes++) {
				if(Double.parseDouble(database[familia][mes])<9500)
				deuda+= (9500-Double.parseDouble(database[familia][mes]));
		}
		System.out.println("La deuda de la familia "+database[familia][0]+" es "+deuda);
		java.util.Date fecha = new Date();
		System.out.println("\n\t"+fecha);

	}

	public static void montoAnio(String database[][],int familia, int mes) {
		int acum=0;
		for (familia = 0; familia < 20 ; familia++) {
			for (mes = 1; mes <= 12 ; mes++) {
				acum+=Double.parseDouble(database[familia][mes]);
			}
		}
		System.out.println("\nEl monto total recaudado del anio es $"+acum);
		java.util.Date fecha = new Date();
		System.out.println("\n\t"+fecha);
	}

	public static void montoMes(String database[][],int familia, int mes) {
		int acum=0;
		System.out.println("Ingrese el mes");
		mes=Lectura.readInt();
		for (familia = 0; familia < 20 ; familia++) {
			acum+=Double.parseDouble(database[familia][mes]);
		}
		System.out.println("\nEl monto total recaudado del mes "+mes+" es $"+acum);
		java.util.Date fecha = new Date();
		System.out.println("\n\t"+fecha);
	}


	public static void deudaMontoAnio(String database[][],int familia, int mes) {
		double acum=0;
		double deuda=0;
		for(familia=0; familia<20; familia++){
			for(mes=1;mes<13;mes++) {
				if(Double.parseDouble(database[familia][mes])==0);
				else if(Double.parseDouble(database[familia][mes])<9500)
					deuda+=9500-Double.parseDouble(database[familia][mes]);
				acum+=deuda;
			}
		}
		System.out.println("La deuda total del anio es de: $" +deuda);
		java.util.Date fecha = new Date();
		System.out.println("\n\t"+fecha);
	}


	public static void deudaMontoMes(String database[][], int familia, int mes) {
		double deuda=0;
		System.out.println("Ingrese el mes");
		mes=Lectura.readInt();
		for(familia=0;familia<20;familia++) {
			if(Double.parseDouble(database[familia][mes])==0);
			else if(Double.parseDouble(database[familia][mes])<9500)
				deuda+=9500-Double.parseDouble(database[familia][mes]);
		}
		System.out.println("La deuda total del mes " +mes +" es de: $" +deuda);
		java.util.Date fecha = new Date();
		System.out.println("\n\t"+fecha);
	}


	public static void montoActual(String database[][],int familia, int mes) {
		System.out.println("Ingrese la familia de la que desea obtener los datos");
		familia=Lectura.readInt();
		int acum=0;
		for(mes=1;mes<=12;mes++)
			acum+=Double.parseDouble(database[familia][mes]);
		System.out.println("El total pagado a la fecha por la familia "+(database[familia][0])+" es de $"+acum);
		java.util.Date fecha = new Date();
		System.out.println("\n\t"+fecha);
	}
}

