import java.util.Scanner;
public class MediaYDesviacion {
    public static double media(int v1, int v2, int v3, int v4) {
        double media=(v1+v2+v3+v4)/4.0;
        return media;
    }
    public static double desviacion(int v1, int v2, int v3, int v4) {
        double desviacion=Math.pow(Math.pow(((v1+v2+v3+v4)-((v1+v2+v3+v4)/4.0))/4.0,2),0.5);
        return desviacion; 
    }
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        //Introducimos los datos
        int valor1;
        int valor2;
        int valor3;
        int valor4;
        System.out.print("Introduce los cuatro valores:");
        valor1=teclado.nextInt();
        valor2=teclado.nextInt();
        valor3=teclado.nextInt();
        valor4=teclado.nextInt();
        //Imprimir en la pantalla la media y desviacion
        System.out.printf("La media de los valores vale %.4f\ny la desviación típica vale %.4f\n", media(valor1, valor2, valor3, valor4), desviacion(valor1, valor2, valor3, valor4));
        teclado.close();
    }
}
