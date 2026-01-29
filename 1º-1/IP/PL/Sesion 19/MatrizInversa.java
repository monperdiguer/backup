import java.util.Scanner;

public class MatrizInversa {
    public static int[][] leeMatrizInt(Scanner t){
        System.out.print("Introduce el tamaño de la matriz(filas y columnas): ");
        int filas=t.nextInt();
        int columnas=t.nextInt();

        int[][] matriz=new int[filas][columnas];
        System.out.println("Matriz: ");
        for(int f=0; f<matriz.length;f++)
            for(int c=0;c<matriz[f].length;c++)
                matriz[f][c]=t.nextInt();
        return matriz;
    }
    public static int[][] imprimeMatrizInt(int[][] matriz){
        System.out.println("Matriz leída: ");
        for(int f=0; f<matriz.length;f++){
            for(int c=0;c<matriz[f].length;c++)
                System.out.printf(" %d",matriz[f][c]);
            System.out.println();
        }
        return matriz;

    }
    public static int[][] imprimeMatrizInversa(int[][] matriz){
        System.out.println("Matriz Inversa: ");
        for(int f=matriz.length-1; f>=0;f--){
            for(int c=matriz[f].length-1;c>=0;c--)
                System.out.printf(" %d",matriz[f][c]);
            System.out.println();
        }
        return matriz;

    }
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        int[][] matriz=leeMatrizInt(t);
        imprimeMatrizInt(matriz);

        imprimeMatrizInversa(matriz);
        t.close();
       
    }
}
