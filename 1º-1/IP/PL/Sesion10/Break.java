import java.util.Scanner;
public class Break{
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        System.out.print("Introduzca una secuencia de numeros enteros");
        int n = t.nextInt();
        //encontrado(n%2!=0 || n%5==0)
        //no encontrado(n%2==0 && n%5!=0)
        while(n>=0){
            if(n%2!=0 || n%5==0) break;
            n=t.nextInt();
        }
        if (n>=0) System.out.print("La secuencia SI contiene algun numero impar o multiplo de 5."); 
         else System.out.print("La secuencia NO contiene ningun numero impar o multiplo de 5.");  
        t.close(); 
    }
}