import java.util.Scanner;

public class Aceleracion {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        //Pedimos el tiempo en segundos
        System.out.print("Introduce el tiempo(s) que tardará en alcanzar 100 Km/h: ");
        double t=teclado.nextDouble();
        //Pasamos la velocidad de Km/h a m/s
        final double vi= 0;
        final double vf= (100*1000)/3600.0;

        //Calcular la aceleración
        double a=(vf-vi)/t;
        System.out.printf("La aceleración vale: %.2f m/s^2", a);
        teclado.close();
    }
}