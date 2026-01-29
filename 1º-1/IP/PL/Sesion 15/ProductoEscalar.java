import java.util.Scanner;
public class ProductoEscalar{
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

      if(x.length != y.length)
         System.out.print("Los vectores tienen diferentess longitudes");
      else{
         int prod_escalar=0;
         for(int i=0; i<x.length; i++)
            prod_escalar+=x[i]*y[i];
         System.out.printf("El producto escalar es %d\n", prod_escalar);
      }

   }
}