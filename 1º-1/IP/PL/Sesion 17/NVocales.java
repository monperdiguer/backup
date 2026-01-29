import java.util.Scanner;
public class NVocales {
    public static boolean Vocal(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
            return true;
        else return false;
    }
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Cadena: ");
        String cadena=t.next();
        int vocal=0;
        for(int i=0; i<cadena.length(); i++ ){
            if(Vocal(cadena.charAt(i)))
                vocal++;
        }
        System.out.printf("La cadena %s tiene %d vocales\n", cadena, vocal);
        t.close();
    }

}

