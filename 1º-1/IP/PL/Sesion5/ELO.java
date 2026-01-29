import java.util.Scanner;
public class ELO {
    public static int puntosELO(int A, int K, int B, double res){
        double exp_A=Math.pow(10, A/400.0);
        double exp_B=Math.pow(10, B/400.0);
        return (int) (A+K*(res-exp_A/(exp_A+exp_B)));

    }    

    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        //Introducimos las variables
        System.out.print("Introduce los puntos de A:");
        int A=teclado.nextInt();
        System.out.print("Introduce la K del jugador:");
        int K=teclado.nextInt();
        System.out.print("Introduce los puntos de B:");
        int B= teclado.nextInt();
        System.out.print("Resultado (1 si ganó, 0 si perdió, 0.5 si hicieron tablas):");
        double res=teclado.nextDouble();

        System.out.printf("El jugador A pasa de %d puntos a %d puntos", A, puntosELO(A, K, B, res) );
        teclado.close();
    }
}
