import java.util.Scanner;
/**
 * MillasAKm
 */

public class MillasAKm {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        // Pedir al usuario el número de millas
        System.out.println("Escribe el número de millas: ");
        double millas = teclado.nextDouble();

        //Convertir el número de millas
        double km = millas * 1.609344;

        //Imprimir el resueltado
        //printf para poner un mensaje
        System.out.printf("%.2f millas son %.3f kilometros\n", millas, km); 

    }
}