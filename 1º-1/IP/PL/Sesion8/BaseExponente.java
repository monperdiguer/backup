import java.util.Scanner;
public class BaseExponente {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        System.out.print("Introduzca dos números enteros(base, exponente):");
        int base=t.nextInt();
        int exponente=t.nextInt();

        long potencia=1;
        for(int i=1; i<=exponente; i++)
            potencia*=base;

        System.out.printf("La potencia con base %d y con exponente %d vale %d\n", base, exponente, potencia);
        t.close();
    }
}