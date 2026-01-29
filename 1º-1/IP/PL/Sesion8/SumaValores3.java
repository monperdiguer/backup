import java.util.Scanner;
public class SumaValores3 {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        System.out.print("Introduzca dos números enteros (n,m):");
        int n=t.nextInt();
        int m=t.nextInt();
        int suma=0;
        int i=n+1;
        while(i<m){
            //Sumamos el siguiente valor de la secuencia hasta llegar a m
            suma+=i;
            i++;
        }
        System.out.printf("El sumatorio es igual a %d\n", suma);
        t.close();   
    
    }
}