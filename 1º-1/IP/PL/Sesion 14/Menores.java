import java.util.Scanner;
public class Menores {
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

    //Numero de componentes menores que la siguiente
    int menores=0;
    for(int i =0; i<v.length-1;i++){
        if(v[i]<v[i+1]) menores++;
    }
    System.out.printf("Hay %d componentes menores que la siguiente", menores);
    t.close();

    }
}