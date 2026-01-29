import java.util.Scanner;
public class Inscripcion {
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        System.out.print("Introduzca la categoría(I/D/M) y la edad(a/i/j/s): ");
        char cat= t.next().charAt(0);
        char edad=t.next().charAt(0);

        if((cat=='M') && ((edad=='j') || (edad=='s'))) System.out.print("Pagan 15 euros");
        else if((cat=='I') && ((edad=='j') || (edad=='s'))) System.out.print("Pagan 25 euros");
        else if (((cat=='D') || (cat=='M')) && ((edad=='a') || (edad=='i'))) System.out.print("Pagan 10 euros");
        else System.out.print("Pagan 20 euros");
        t.close();
    }
    
}
