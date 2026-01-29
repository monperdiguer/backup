import java.util.Scanner;
public class Contenido2{
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce un numero entero: ");
        int numero=t.nextInt();
        System.out.print("Introduce un digito: ");
        int digito=t.nextInt();

        int i=numero;
        while(i!=0){
            if(digito==i%10) break;
            i/=10;
        }
        if(i!=0)
        System.out.printf("El numero %d contiene al digito %d\n", numero, digito);
        else System.out.printf("El numero %d no contiene al digito %d\n", numero, digito);
        t.close();
    }
}