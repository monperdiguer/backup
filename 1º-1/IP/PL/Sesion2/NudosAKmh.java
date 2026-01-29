import java.util.Scanner;

public class NudosAKmh {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        // Pedir al usuario el número de millas
        System.out.println("Escribe el número de nudos: ");
        double nudos = teclado.nextDouble();


        // Convertir el número de nudos
        double kmh = nudos * 1.852;

        // Imprimir el resultado
        System.out.printf("%.2f nudos son %.3f kilometros hora\n", nudos, kmh); 

    }
    
}
