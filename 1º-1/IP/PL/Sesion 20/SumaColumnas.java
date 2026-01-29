import java.util.Scanner;
public class SumaColumnas{
    public static int[][] leematriz(Scanner teclado){
        System.out.println("Introduzca el tamaño de la matriz: ");
        int filas=teclado.nextInt();
        int columnas=teclado.nextInt();
        
        int[][]matriz=new int[filas][columnas];
        System.out.print("Introduzca la matriz: \n");
        for(int f=0;f<matriz.length;f++){
            for(int c=0; c<matriz[f].length;c++)
            matriz[f][c]=teclado.nextInt();
        }
        return matriz;

    }
    public static int[][] imprimematriz(int[][] matriz){
        System.out.println("Matriz leída: \n");
        for(int f=0;f<matriz.length;f++){
            for(int c=0; c<matriz[f].length;c++)
                System.out.printf("%d",matriz[f][c]);
                System.out.println();
        }
        return matriz;
    }
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        int[][] matriz=leematriz(teclado);
        imprimematriz(matriz);

        System.out.println("Suma columnas: ");
        for(int columnas=0;columnas<matriz[0].length;columnas++){
        int sumacolumnas=0;
        for(int filas=0;filas<matriz.length;filas++)
            sumacolumnas+=matriz[filas][columnas];
       System.out.printf("%d",sumacolumnas);
       }
       System.out.println();
       teclado.close();
    }

}