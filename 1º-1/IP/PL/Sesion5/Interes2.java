import java.util.Scanner;
public class Interes2 {
    public static double intereses(double cantidad, double tipo, int meses, boolean retencion){
        if(retencion) return (double) (cantidad*(tipo/100.0)*(meses/12.0)*(19/100.0));
        else  return (double) (cantidad*(tipo/100.0)*(meses/12.0));
    }
         public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce la cantidad de dinero invertida:");
        double cantidad=t.nextDouble();
        System.out.print("Introduce el tipo de interés (%):");
        double tipo=t.nextDouble();
        System.out.print("Introduce el plazo en meses:");
        int meses=t.nextInt();
        System.out.print("¿Tiene retención? (s/n):");
        char ret=t.next().charAt(0);
        boolean retencion=(ret=='s');

        System.out.printf("La cantidad de intereses que va a cobrar un cliente es %.2f", intereses(cantidad, tipo, meses, retencion));
        t.close();
    }
}