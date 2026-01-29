import java.util.Scanner;
public class MultiploYMenor {
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
    
        //Numero de componentes multiplos de 7 y menores que la siguiente
        int multiplo7_menores=0;
        for(int i =0; i<v.length-1;i++){
            if(v[i]%7==0 && v[i]<v[i+1]) multiplo7_menores++;
        }
        System.out.printf("Hay %d componentes multiplo de 7 y menores que la siguiente", multiplo7_menores);
        t.close();
    
        }
}
