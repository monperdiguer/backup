//Examen 21-22 ej.6
import java.util.Scanner;
public class Subvenciones {
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        System.out.print("Introduzca sus ingresos: ");
        double ing=t.nextDouble();
        System.out.print("Introduzca su país de procedencia: ");
        char pais=t.next().charAt(0);

        if((ing>=45000.0) && ((pais=='I') || (pais=='R')))
         System.out.print("Se le subvenciona un 10%");
        else if(((ing<=20000.0) && ((pais=='E') || (pais=='P') || (pais=='I'))) || ((ing<45000.0) || (pais=='E')))
            System.out.print("Se le subvenciona un 50%");
        else System.out.print("Se le subvenciona un 20%");
        t.close();

    }
    
}
