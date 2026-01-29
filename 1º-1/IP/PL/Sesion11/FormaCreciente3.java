import java.util.Scanner;
public class FormaCreciente3{
public static boolean FormaCreciente(Scanner t){
    System.out.print("Introduce una secuencia de enteros:");
    int anterior = t.nextInt();
    int actual = t.nextInt();
    while(actual!=0){
        if(actual<anterior) return false;
        anterior=actual;
        actual=t.nextInt();
    }
    return true;
}

public static void main(String[] args){
    Scanner t = new Scanner(System.in);
        if (FormaCreciente(t)) System.out.print("La secuencia está en orden creciente"); 
        else System.out.print("La secuencia NO está en orden creciente");  
        t.close();
}
}