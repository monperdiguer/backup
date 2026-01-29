import java.util.Scanner;
public class Impar {
    public static boolean es_Impar(int n){
        while(n!=0){
            n=n/10;
            if(n%2!=0) return true;
            else n=n/10;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce la secuencia: ");
        int n=t.nextInt();
        if(es_Impar(n)) System.out.print("Hay un numero impar");
        else System.out.print("No hay un numero impar");
        t.close();
    }
}
