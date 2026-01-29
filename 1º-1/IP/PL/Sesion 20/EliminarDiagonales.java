import java.util.Scanner;
public class EliminarDiagonales {
    public static char[][] leematriz(Scanner teclado){
        System.out.println("Introduzca el tamaño de la matriz: ");
        int tamaño=teclado.nextInt();
        
        char[][]matriz=new char[tamaño][tamaño];
        System.out.print("Introduzca la matriz: \n");
        for(int f=0;f<matriz.length;f++){
            for(int c=0; c<matriz[f].length;c++)
            matriz[f][c]=teclado.next().charAt(0);
        }
        return matriz;
    }
    public static char[][] imprimematriz(char[][] matriz){
        for(int f=0;f<matriz.length;f++){
            for(int c=0; c<matriz[f].length;c++)
                System.out.printf(" %c ",matriz[f][c]);
                System.out.println();
        }
        return matriz;
    }
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        char[][] matriz=leematriz(teclado);
        System.out.println("Carácter: ");
        char letra=teclado.next().charAt(0);

        int tamaño=matriz.length; //la matriz tiene que ser cuadrada
        for(int i=0;i<matriz.length;i++){
            //Si esta en la diagonal
            if(matriz[i][i]==letra)
                matriz[i][i]='-';
            if(matriz[i][tamaño-1-i]==letra)
                matriz[i][tamaño-1-i]='-';
        }
        imprimematriz(matriz);
    }
//???!!!!
}
