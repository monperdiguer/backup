import java.util.Scanner;
public class Minimo{
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduzca la secuencia de números reales negativos: ");
        double minimo=t.nextDouble();
        double m=t.nextDouble();
        while(m<0){
            if(m<minimo){
                minimo=m;
            }           
        m=t.nextDouble();
        }
        System.out.printf("El mínimo es: %.1f\n", minimo);
        t.close();   
    }
}