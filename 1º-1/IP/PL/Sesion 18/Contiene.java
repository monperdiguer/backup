import java.util.Scanner;
public class Contiene{
    public static String SubCadena(String subcadena, int principio, int fin){
        if(fin>=subcadena.length())
            fin=subcadena.length()-1;
        String subCadena="";
        for(int i =principio; i<=fin;i++)
            subCadena+=subcadena.charAt(i);
        return subCadena;

    }
    public static boolean sonIguales(String cadena1, String cadena2){
        int i=0;
        while(i<cadena1.length() && i<cadena2.length()){
            if(cadena1.charAt(i)!=cadena2.charAt(i)) return false;
            i++;
        }
        return true;
    }
    public static boolean contiene(String cadena, String subcadena){
        int lCadena=cadena.length();
        int lSubCadena=subcadena.length();
        if(lCadena==0 || lSubCadena==0 || lSubCadena>lCadena)
            return false;
        for(int i = 0; i<=lCadena-lSubCadena; i++){
            if(sonIguales(SubCadena(cadena,i,i+lSubCadena-1),subcadena))
                return true;
        }
        return false;
    }
    public static void main(String [] args){
        Scanner t=new Scanner(System.in);
        System.out.println("Introduzca la caden: ");
        String cadena=t.next();
        System.out.println("Introduzca la subcadena: ");
        String subcadena=t.next();

        if(contiene(cadena,subcadena)) System.out.printf("La cadena %s contiene la subcadena %s",cadena, subcadena);
        else System.out.printf("La cadena %s NO contiene la subcadena %s",cadena, subcadena);
        t.close();
    }

}