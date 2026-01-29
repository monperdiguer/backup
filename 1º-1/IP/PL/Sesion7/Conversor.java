import java.util.Scanner;
public class Conversor{
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        System.out.println("Selecciona tu conversor: \n1) Millas a Kms \n2) Metros a Yardas \n3) Libras a Kgs \nOpción?");
        char conver=t.next().charAt(0);
        System.out.print("Introduzca el dato:");
        double n=t.nextDouble();
        
        //Convertir dependiendo de la selección
        if(conver=='1'){
            double kms = n * 1.609344;
            System.out.printf("%.2f millas son %.3f kilometros\n", n, kms);
        } 
        else if (conver=='2'){
            double yardas = 1.09361332 * n;
        System.out.printf("%.2f ms son %.4f yardas", n, yardas);
        }
        else{
            double kg = n * 0.45359237;
        System.out.printf("%.2f libras son %.4f kilogramos\n", n, kg);
        }
        t.close();
    }
}