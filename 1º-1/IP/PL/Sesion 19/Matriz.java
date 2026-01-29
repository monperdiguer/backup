import java.util.Scanner;

public class Matriz {
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce el tamaño de la matriz(filas y columnas): ");
        int filas=t.nextInt();
        int columnas=t.nextInt();

        int[][] matriz=new int[filas][columnas];
        System.out.println("Matriz: ");
        for(int f=0; f<matriz.length;f++)
            for(int c=0;c<matriz[f].length;c++)
                matriz[f][c]=t.nextInt();
    
        //Imprimir la matriz
        System.out.println("Matriz leída: ");
        for(int f=0; f<matriz.length;f++){
            for(int c=0;c<matriz[f].length;c++)
                System.out.printf(" %d",matriz[f][c]);
            System.out.println();
        }
        t.close();
    }
}
