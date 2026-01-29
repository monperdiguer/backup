import java.util.Scanner;
public class BaseExponente2 {
    public static double myPow(int base, int exponente){
        double potencia=1;
        for(int i=1; i<=Math.abs(exponente); i++)
            potencia*=base;
        
        if(exponente<0)
            return 1.0/potencia;
        else
            return potencia;
    }
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        System.out.print("Introduzca dos números enteros(base, exponente):");
        int base=t.nextInt();
        int exponente=t.nextInt();

        System.out.printf("La potencia con base %d y con exponente %d vale %.2f\n", base, exponente, myPow(base,exponente));
        t.close();
    }
}
