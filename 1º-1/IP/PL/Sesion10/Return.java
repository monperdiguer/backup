import java.util.Scanner;
public class Return{
    public static boolean ImparOMultiplo5(Scanner t){
        System.out.print("Introduzca una secuencia de numeros enteros");
        int n = t.nextInt();
        //encontrado(n%2!=0 || n%5==0)
        //no encontrado(n%2==0 && n%5!=0)
        while(n>=0 && (n%2==0 && n%5!=0))
            n=t.nextInt();
         if (n>=0) return true; 
         else return false; 
    }
   
}