import java.util.Scanner;

public class ICM {
    public static double icm(double p, double h) {
        //Calcular el ICM
        double icm=p/(Math.pow(h,2));
        return icm;
    }
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        double peso;
        double altura;
        System.out.print("Introduce el peso y la altura:");
        peso=teclado.nextDouble();
        altura=teclado.nextDouble();
        System.out.printf("Indice de Masa Corporal: %.2f\n", icm(peso, altura));
        teclado.close();
    }
}
