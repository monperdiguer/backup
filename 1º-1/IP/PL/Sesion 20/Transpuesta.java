import java.util.Scanner;
public class Transpuesta {
    public static int[][] leematriz(Scanner teclado){
        System.out.print("Introduzca el tamaño de la matriz: ");
        int filas=teclado.nextInt();
        int columnas=teclado.nextInt();
        System.out.print("Introduzca la matriz: \n");
        int[][] matriz=new int[filas][columnas];
        for(int f=0; f<matriz.length;f++){
            for(int c=0;c<matriz[f].length;c++)
                matriz[f][c]=teclado.nextInt();
        }
        return matriz;
    }
    public static int[][] imprimematriz(int[][] matriz){
        System.out.print("Matriz: \n");
        for(int filas=0; filas<matriz.length;filas++){
            for(int columnas=0;columnas<matriz[filas].length;columnas++)
                System.out.printf(" %d ",matriz[filas][columnas]);
            System.out.println();
        }
        return matriz;
    }

    public static int[][] matriztranspuesta(int[][] matriz){
        int filas=matriz.length;
        int columnas=matriz[0].length;
        int[][] transpuesta= new int[columnas][filas];
        for (int f=0; f<filas;f++){
            for(int c=0;c<columnas;c++){
                transpuesta[c][f]=matriz[f][c];
            }
            System.out.println();
        }
        return transpuesta;
    }
    public static int[][] imprimetranspuesta(int[][] transpuesta){
        System.out.print("Matriz transpuesta: \n");
        for(int filas=0; filas<transpuesta.length;filas++){
            for(int columnas=0;columnas<transpuesta[filas].length;columnas++)
                System.out.printf(" %d ",transpuesta[filas][columnas]);
            System.out.println();        
        }
        
        return transpuesta;
    }
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        int[][] matriz=leematriz(teclado);
        imprimematriz(matriz);
        matriztranspuesta(matriz);
        int[][] transpuesta=matriztranspuesta(matriz);
        imprimetranspuesta(transpuesta);
        teclado.close();
    }
}