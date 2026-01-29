import java.util.Scanner;
public class Contenido3{
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce un numero entero: ");
        int numero=t.nextInt();
        System.out.print("Introduce un digito: ");
        int digito=t.nextInt();

        int i=numero;
        while(i!=0 && digito!=i%10)
            i/=10;
        if(i!=0)
        System.out.printf("El numero %d contiene al digito %d\n", numero, digito);
        else System.out.printf("El numero %d no contiene al digito %d\n", numero, digito);
        t.close();
    }
}
