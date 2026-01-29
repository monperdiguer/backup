import java.util.Scanner;
public class Contenido {
    public static boolean contiene(int num, int d){
        int i=num;
        while(i!=0){
            if(d==i%10) return true;
            //Obtenemos siguiente digito
            i/=10;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce un numero entero: ");
        int numero=t.nextInt();
        System.out.print("Introduce un digito: ");
        int digito=t.nextInt();

        //Busqueda del digito en el numero
        if(contiene(numero,digito))
        System.out.printf("El numero %d contiene al digito %d\n", numero, digito);
        else System.out.printf("El numero %d no contiene al digito %d\n", numero, digito);
        t.close();
    }
}