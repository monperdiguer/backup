import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class perrosPeligrososTest1{

	public static void main(String[] args) {
		Scanner in = null;
		Formatter out = null;
		String inputFileName = "censoPerrosPeligrosos.txt";
		String outputFileName = "output.txt";
		try {
			in = new Scanner(new FileInputStream(inputFileName));
			out = new Formatter(outputFileName);
			
			System.out.println("RAZA TAMAÑO CP BARRIO CANTIDAD");
			int grande = 0;
			int mediano = 0;
			int pequeño = 0;
			
			while(in.hasNext()){
				System.out.println(in.next() + ' ' + in.next()  + ' ' + in.nextInt()  + ' ' + in.next()  + ' ' + in.nextInt());
				
				String nombre = in.next();
				String tamaño = in.next();
				int cp = in.nextInt();
				String barrio = in.next();
				int cantidad = in.nextInt();
				
				
				
				if(tamaño == "Grande") {
					grande++;
				}
				if(tamaño == "Mediano") {
					mediano++;
				}
				if(tamaño == "Pequeño") {
					pequeño++;
				}
				
				out.format("%-33s%-10s%-7d%-25s%-3d\n", in.next(), in.next(), in.nextInt(), in.next(), in.nextInt());
			}
			System.out.printf("%d grandes, %d medianos, %d pequeños", grande, mediano, pequeño);
			
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
		}
		finally {
			if (in!=null) in.close();
		}
		
	}
}