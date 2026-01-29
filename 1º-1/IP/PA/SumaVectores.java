import java.util.Scanner;
public class SumaVectores{
    public static int[] leeVector(Scanner teclado){
        System.out.println("Introduce el tamaño del vector: ");
        int tamaño=teclado.nextInt();
        System.out.println("Introduce el vector: ");
        int[] vector=new int[tamaño];
        for(int i=0;i<vector.length;i++)
            vector[i]=teclado.nextInt();
        return vector;
    }
    public static int[] imprimeVector(int[] vector){
        for(int i=0;i<vector.length;i++)
            System.out.printf(" %d",vector[i]);
        System.out.println();
        return vector;
    
    }
    public static int[] sumaVectores(int[] vector){
        int[] suma= new int[vector.length];
        suma[0]=vector[0];
        for(int i=1;i<vector.length;i++){
            suma[i]= suma[i-1]+vector[i];
        }
        for(int i=0;i<suma.length;i++)
            System.out.printf("%d ",suma[i]);
        System.out.println();
        return suma;
    }
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        int[] vector=leeVector(teclado);
        imprimeVector(vector);
        System.out.print("Si sumamos las componentes del vector con la anterior el vector quedaría\n");
        sumaVectores(vector);
        teclado.close();
    }
}