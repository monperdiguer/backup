import java.util.Scanner;
public class SensacionTermica{
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        System.out.print("Introduzca la temperatura (de 0 a 10 ºC): ");
        double T=t.nextDouble();
        System.out.print("Introduzca la calidad del aire: ");
        char aire=t.next().charAt(0);

        if(((T>=7.5) || (T<=10)) && (aire=='N'))
            System.out.print(T-(12.5));
        else if((T<2.5) && (aire=='M'))
            System.out.print(T-20);
        else if((T<2.5) && ((aire=='N') || (aire=='A')) || (((T>=2.5) || (T<5)) && (aire=='M')))
            System.out.print(T-(17.5));
        else System.out.print(T-15);
        t.close();
    }
}        