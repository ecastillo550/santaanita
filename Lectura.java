import java.io.*;

class Lectura{
	public static byte readByte(){
		String z;
		byte q;
		DataInputStream w = new DataInputStream(System.in);
		try{
			z=w.readLine();
		}
		catch (IOException e){z="0";}
		q = Byte.parseByte(z);
		return q;
	}
	public static short readShort(){
		String z;
		short q;
		DataInputStream w = new DataInputStream(System.in);
		try{
			z=w.readLine();
		}
		catch (IOException e){z="0";}
		q = Short.parseShort(z);
		return q;
	}
	public static int readInt(){
		String z;
		int q;
		DataInputStream w = new DataInputStream(System.in);
		try{
			z=w.readLine();
		}
		catch (IOException e){z="0";}
		q = Integer.parseInt(z);
		return q;
	}
	public static long readLong(){
		String z;
		long q;
		DataInputStream w = new DataInputStream(System.in);
		try{
			z=w.readLine();
		}
		catch (IOException e){z="0";}
		q = Long.parseLong(z);
		return q;
	}
	public static float readFloat(){
		String z;
		float q;
		DataInputStream w = new DataInputStream(System.in);
		try{
			z=w.readLine();
		}
		catch (IOException e){z="0";}
		q = Float.parseFloat(z);
		return q;
	}
	public static double readDouble(){
		String z;
		double q;
		DataInputStream w = new DataInputStream(System.in);
		try{
			z=w.readLine();
		}
		catch (IOException e){z="0";}
		q = Double.parseDouble(z);
		return q;
	}
	public static String readString(){
		String z;
		DataInputStream w = new DataInputStream(System.in);
		try{
			z=w.readLine();
		}
		catch (IOException e){z="0";}
		return z;
	}
	public static char readChar(){
		String z;
		char q;
		DataInputStream w = new DataInputStream(System.in);
		try{
			z=w.readLine();
		}
		catch (IOException e){z="0";}
		q = z.charAt(0);
		return q;
	}
}