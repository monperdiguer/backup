//Secuencia que acaba en O, buscar si hay algún negativo
import java.util.Scanner;
public class Negativo {
    public static void main(String[] args){
        Scanner t =new Scanner(System.in);
        System.out.print("Introduzca la secuencia: ");
        int n=t.nextInt();

        while(n!=0){
            if(n<0) break;
            n=t.nextInt();
        }
        if(n!=0) System.out.print("Hay un nº negativo");
        else System.out.print("NO hay un nº negativo");
        t.close();
    }
}
