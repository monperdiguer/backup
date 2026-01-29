import java.util.Scanner;
public class Ecuacion2º {
     public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce los coeficientes de la ecaución:");
        double a=t.nextDouble();
        double b=t.nextDouble();
        double c=t.nextDouble();

        double radicando=b*b-4*a*c;
        if(radicando < 0)
        System.out.println("La ecuación no tiene raices reales");
        else if(radicando == 0){
            double raíz=-b/(2.0*a);
            System.out.printf("La ecuación tiene una raíz real %.2f", raíz);

        }
        else {
            double r1=(-b-Math.sqrt(radicando))/2.0;
            double r2=(-b+Math.sqrt(radicando))/2.0;
            System.out.printf("La ecuacion tiene dos raíces reales %.2f y %.2f", r1, r2);
        }
        t.close();
     }
}
