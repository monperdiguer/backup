import java.util.Scanner;
public class Euler{
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        System.out.print("Introduzca n: ");
        int n=t.nextInt();

        double e= 0.0;
        for(int i=0; i<=n; i++){

            //Calculo factorial
            double factorial= 1;
            for(int j=2; j<=i;j++)
                factorial*=j;

            //Calculo de e        
            e+=1.0/factorial;
        }
        System.out.printf("El valor de e vale aprox. %.10f\n", e);
        t.close();
    }
}