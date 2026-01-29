import java.util.Scanner;
public class Aceleracion2{
    public static double a(double vi, double vf, double t){
        return (vf-vi)/t;
    }
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        //Pedimos el tiempo en segundos
        System.out.print("Introduce el tiempo(s) que tardará en alcanzar 100 Km/h: ");
        double t=teclado.nextDouble();
        //Pasamos la velocidad de Km/h a m/s
        final double vi= 0;
        final double vf= (100*1000)/3600.0;
        System.out.printf("La aceleración vale: %.2f m/s^2", a(vi, vf, t));
        teclado.close();
    }
}