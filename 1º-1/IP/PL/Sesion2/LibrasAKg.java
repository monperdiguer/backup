import java.util.Scanner;

public class LibrasAKg {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Pedir al usuario el número de libras
        System.out.println("Escribe el número de libras: ");
        double libras = teclado.nextDouble();

        //Convertir las libras en kg
        double kg = libras * 0.45359237;
        System.out.printf("%.2f libras son %.4f kilogramos\n", libras, kg);

    }
}
