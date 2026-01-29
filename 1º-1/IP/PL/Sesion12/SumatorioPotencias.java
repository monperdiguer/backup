import java.util.Scanner;
public class SumatorioPotencias{
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce un numero natural:");
        int n=t.nextInt();

        //Con Math.pow
        double suma=0;
        for(int i=1;i<=n;i++){
            suma+=Math.pow(i,i);
        }
        System.out.printf("Resultado con Math.pow(): %.0f\n", suma);

         //Con bucle
         double suma2=0;
         for(int i=1;i<=n;i++){
            double potencia=1;
            for(int j=1;j<=i;j++)
                potencia*=i;
                suma2+=potencia;
        }
        System.out.printf("Resultado sin Math.pow(): %.0f\n", suma2);
        t.close();
    }
}