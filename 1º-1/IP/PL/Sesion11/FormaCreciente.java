import java.util.Scanner;
public class FormaCreciente{
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        System.out.println("Introduzca una secuencia de numeros enteros: ");
        int anterior = t.nextInt();
        int actual = t.nextInt();
        while(actual!=0){
            if(actual<anterior) break;
            anterior=actual;
            actual=t.nextInt();
        }
        if (actual!=0) System.out.println("La secuencia NO está en orden creciente"); 
        else System.out.println("La secuencia SI está en orden creciente");  
        t.close();
    }
}
//NO FUNCIONA!!!