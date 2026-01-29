import java.util.Scanner;
public class LeeVectorDouble {
   public static double[] leeVectorDouble(Scanner t){
    System.out.print("Introduzca el tamaño de vector: ");
    int tamaño=t.nextInt();

    //Reservamos memoria para el vector
    double[] v= new double[tamaño];

    System.out.print("Introduzca las componentes del vector: ");
    for(int i=0; i<v.length; i++)
        v[i]=t.nextDouble();
    return v;
   }
   public static void main(String[] args){
    Scanner t=new Scanner(System.in);
    
    //Llamamos al vector
    double[] v= leeVectorDouble(t);

    System.out.print("Vector: {");
    for(int i=0; i<v.length;i++)
        System.out.printf("%.0f", v[i]);
    System.out.print("}\n");
    t.close();
   }
}
