import java.util.Scanner;
public class NIF {
    public static boolean NIF(String letra){
            while(0=='T' || 1=='R' || 2=='W' || 3=='A' || 4=='G' ||
            5=='M' || 6=='Y' || 7=='F'|| 8=='P' || 9=='D' ||
            10=='X' || 11=='B' || 12=='N' || 13=='J' || 14=='Z' ||
            15=='S' || 16=='Q' || 17=='V' || 18=='H' || 19=='L'||
            20=='C' || 21=='K' || 22=='E') return letra;
    }
    public static void main(String[] args){
        Scanner t= new Scanner(System.in);
        System.out.print("Introduca el DNI: ");
        String DNI=t.next();

        int suma=0;
        for(int i=0; i<DNI.length();i++){
            suma=suma+DNI.charAt(i);
        }
        int letra_NIF=suma/23;
        System.out.printf("DNI: %s\n letra NIF: %s\n",DNI,NIF(letra_NIF));
        t.close();

    }
    
}
//????
