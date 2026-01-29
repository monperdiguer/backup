import java.util.Scanner;
public class Condicional1{
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce un número cualquiera:");
        int x=t.nextInt();

        //Condicional si para hallar el resultado
        if(0<=x)
            if(x<=50) System.out.printf("El triple de x es %d", x*3);
            else System.out.printf("El doble de x es %d", x*2);
        else System.out.printf("El valor absoluto de x es %d", -x);
        t.close();
    }
}