import java.util.Scanner;
public class Invertido{
    public static int[] leeVector(Scanner t){
    System.out.print("Introduzca tamaño del vector: ");
    int tamaño= t.nextInt();
    System.out.print("Introduzca las componentes del vector: ");
    int[] v = new int[tamaño];
    //Leer componentes
    for (int i=0; i<v.length; i++)
        v[i]=t.nextInt();
    return v;
    }
    public static int[] imprimeVectorInt(int[] v){
        System.out.print("Vector: {");
          for(int i=0; i<v.length;i++)
              System.out.printf(" %d ", v[i]);
          System.out.print("}");
        return v;
    }
    public static void main(String[] args){
        Scanner tec= new Scanner(System.in);
        int[] vector= leeVector(tec);
        imprimeVectorInt(vector);

        System.out.print("Invertido: {");
        for(int i=vector.length-1; (i>=0) && (i<=vector.length-1);i--)
            System.out.printf(" %d ", vector[i]);
        System.out.print("}");

    }
}