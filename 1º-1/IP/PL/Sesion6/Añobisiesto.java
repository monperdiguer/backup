import java.util.Scanner;
public class Añobisiesto {
    public static void main (String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("¿Es el año bisiesto?");
        int año=t.nextInt();
    
        if((año%4==0) && (!(año%100==0) || (año%400==0)))
            System.out.println("true");
        else System.out.println("false");
        t.close();
    }
}