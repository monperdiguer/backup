import java.util.Scanner;

public class KmAYardas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Pedir al susuario el número de km
        System.out.println("Escribe el número de km");
        double km = teclado.nextDouble();

        //Convertir el número de km a yardas
        double yardas = 1093.6133 * km;
        System.out.printf("%.2f km son %.4f yardas", km, yardas);

    }
}
