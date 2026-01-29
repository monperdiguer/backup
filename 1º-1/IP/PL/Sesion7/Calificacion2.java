import java.util.Scanner;
public class Calificacion2 {
    public static String nota(double t, double p){
        String nota;
        if(t>=9 && p>=9)
        nota="Sobresaliente";

        else if ((t>=7.5 && p>=7.5)&&(t<9 || p<9))
        nota="Notable";
        
        else if (t>=5 && p>=5)
        nota="Suficiente";

        else nota="Insuficiente";
        return nota;
    }
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        System.out.print("Notas teoría y práctica (0-10):");
        double t=teclado.nextDouble();
        double p=teclado.nextDouble();

        System.out.printf("Con %.1f y %.1f tienes un %s\n", t, p, nota(t,p));
        teclado.close();
    }
}

