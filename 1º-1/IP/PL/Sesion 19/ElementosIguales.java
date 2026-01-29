import java.util.Scanner;
public class ElementosIguales {
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
    public static int elementosIguales(int[][] matriz, int filaBusqueda, int columnaBusqueda){
        int filas=matriz.length;
        int columnas=matriz[0].length;

        int cuantos=0;
        for(int f=0;f<filas; f++){
            if(matriz[f][columnaBusqueda]==matriz[filaBusqueda][columnaBusqueda])
                cuantos++;
        }
        for(int c=0;c<columnas;c++){
            if(matriz[filaBusqueda][c]==matriz[filaBusqueda][columnaBusqueda])
                cuantos++;
        }
        return cuantos-2; //ya que voy a contar dos veces el propio elemento

    }

    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        int[][] matriz=leeMatrizInt(t);
        imprimeMatrizInt(matriz);
        System.out.print("Introduzca en que fila se encuentra el elemento: ");
        int filaBusqueda=t.nextInt();
        System.out.print("Introduzca en que columna se encuentra el elemento: ");
        int columnaBusqueda=t.nextInt();
        System.out.printf("Hay %d elementos iguales", elementosIguales(matriz,filaBusqueda,columnaBusqueda));
        
        t.close();
       
    }
}

