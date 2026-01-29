import java.util.Scanner;
public class Interes {
    public static double interes(double cantidad, double tipo, int meses){
        return (cantidad*(tipo/100.0)*(meses/12.0));
    }
         public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce la cantidad de dinero invertida:");
        double cantidad=t.nextDouble();
        System.out.print("Introduce el tipo de interés (%):");
        double tipo=t.nextDouble();
        System.out.print("Introduce el plazo en meses:");
        int meses=t.nextInt();

        System.out.printf("La cantidad de intereses que va a cobrar un cliente es %.2f", interes(cantidad, tipo, meses));
        t.close();

     }
}
