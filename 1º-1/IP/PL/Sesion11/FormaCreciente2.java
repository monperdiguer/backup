import java.util.Scanner;
public class FormaCreciente2{
public static void main(String[] args){
    Scanner t = new Scanner(System.in);
        System.out.print("Introduzca una secuencia de numeros enteros");
        int anterior = t.nextInt();
        int actual = t.nextInt();
        while(actual!=0 && actual>=anterior){
            anterior=actual;
            actual=t.nextInt();
        }
        if (actual!=0) System.out.print("La secuencia NO está en orden creciente"); 
        else System.out.print("La secuencia SI está en orden creciente");  
        t.close();
    }
}