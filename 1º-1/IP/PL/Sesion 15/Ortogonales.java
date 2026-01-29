import java.util.Scanner;

public class Ortogonales {
    public static int[] leeVectorInt(Scanner t){
      //Medir tamaño
      System.out.print("Introduce el numero de componentes: ");
      int tamaño=t.nextInt();
      //Reservar espacio
      int [] v=new int[tamaño];
      //Leer componente a componente
      System.out.printf("Introduce %d valores enteros: ", tamaño);
      for(int i =0;i<v.length;i++)
         v[i]=t.nextInt();
      //Retornar vector
      return v;
   } 
   public static void main(String[] args){
      Scanner tec=new Scanner(System.in);
      int[] x= leeVectorInt(tec);
      int[] y= leeVectorInt(tec);
      int prod_escalar=0;

      if(x.length != y.length)
         System.out.print("Los vectores tienen diferentess longitudes");
      else{
         for(int i=0; i<x.length; i++)
            prod_escalar+=x[i]*y[i];
      }
      if(prod_escalar==0)
        System.out.print("El producto escalar es 0. Los vectores son ortogonales");
      else  System.out.printf("El producto escalar es %d\n", prod_escalar);
   }
}
