import java.util.Scanner;
public class Mínimo {
    public static int[] leeVector(Scanner t){
        System.out.print("Introduzca el tamaño del vector");
        int tamaño=t.nextInt();
        System.out.print("Introduduce las componentes del vector: ");
        int[] v= new int[tamaño];
        //Leer componentes
        for (int i=0; i<v.length; i++)
            v[i]=t.nextInt();
        return v;
    }
    public static int[] imprimeVectorDouble(int[] v){
        System.out.print("Vector: {");
          for(int i=0; i<v.length;i++)
              System.out.printf(" %d ", v[i]);
          System.out.print("}");
        return v;
    }
        
    public static void main(String[] args){
        Scanner tec=new Scanner(System.in);
        int[] vector= leeVector(tec);
        imprimeVectorDouble(vector);

        int minimo=vector[0];
        for(int i=0;(i<vector.length-1) && (vector[i]<=minimo);i++){
            minimo=vector[i];    
        }
        System.out.printf("Minimo: %d\n",minimo);

    }
}