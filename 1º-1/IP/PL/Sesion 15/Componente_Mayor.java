import java.util.Scanner;
public class Componente_Mayor {
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
        int[] x= leeVector(tec);
        imprimeVectorDouble(x);

        int i=0;
        while((i< x.length-1) && (x[i]<= x[i+1]))
        i++;
        //Si NO fin de secuencia y lo hemos encontrado
        if(i<x.length-1) 
            System.out.printf("Hay una componente mayor que la siguiente %d\n", x[i]);
        else System.out.print("No hay ninguna componente mayor que la siguiente");
    } 
    
}
