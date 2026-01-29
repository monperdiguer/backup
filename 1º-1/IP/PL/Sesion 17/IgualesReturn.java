import java.util.Scanner;
public class IgualesReturn {
    public static boolean Iguales(String c1, String c2){
        int i=0;
        while(i<c1.length() && i<c2.length()){
            if(c1.charAt(i)!=c2.charAt(i)) return false;
            i++;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduzca la primera cadena: ");
        String cadena1=t.next();
        System.out.print("Introduzca la segunda cadena: ");
        String cadena2=t.next();

        
        if(Iguales(cadena1,cadena2)) System.out.print("Las cadenas son iguales");
        else System.out.print("Las cadenas no son iguales");
        t.close();


    }
}
//HACER A PARTIR DEL DE BREAK