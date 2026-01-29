import java.util.Scanner;
public class Iguales {
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduzca la primera cadena: ");
        String cadena1=t.next();
        System.out.print("Introduzca la segunda cadena: ");
        String cadena2=t.next();

        int i=0;
        while(i<cadena1.length() && i<cadena2.length() && (cadena1.charAt(i)==cadena2.charAt(i)))
            i++;
        
        if(i<cadena1.length() && i<cadena2.length()) System.out.print("Las cadenas no son iguales");
        else System.out.print("Las cadenas son iguales");
        t.close();


    }
}
