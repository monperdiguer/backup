import java.util.Scanner;
public class FahrenheitACelsius {
    public static double fahrenheitACelsius(double f) {
        double c=((f-32)*5)/9;
        return c;
    }
    public static void main(String[] args) {
        //Asociar al teclado
        Scanner teclado= new Scanner(System.in);
        //Medimos la temperatura
        double fahrenheit;
        System.out.print("Introduce grados F: ");
        fahrenheit=teclado.nextDouble();
        //Calculmos la conversión usado en el método
        double celsius = fahrenheitACelsius(fahrenheit);
        //Mostramos la tempreatura en celsius
        System.out.printf("%.2f grados fahrenheit son %.2f grados celsius", fahrenheit, celsius);
        teclado.close();
    }
}