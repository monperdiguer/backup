import java.util.Scanner;

public class VolumenEsfera {
    public static double volumenEsfera(double r) {
        //Calcular el volumen 
        double v=4.0/3*Math.PI*Math.pow(r,3); //poner .0 para que haga la division sea decimal
        return v;
    }
    public static void main(String[] args) {
        //Pedir al usuario que introduzca el radio
        Scanner teclado= new Scanner(System.in);
        //Datos de la esfera
        double radio;
        System.out.print("Introduce radio esfera:");
        radio=teclado.nextDouble();
        //Imprimir el volumen
        System.out.printf("Volumen: %.2f\n", volumenEsfera(radio));
        teclado.close();
    }
}