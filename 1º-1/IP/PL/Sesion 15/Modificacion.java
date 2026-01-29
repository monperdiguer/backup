import java.util.Scanner;

public class Modificacion {
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
   public static int[] imprimeVectorInt(int[] v){
      System.out.print("Vector: {");
        for(int i=0; i<v.length;i++)
            System.out.printf(" %d ", v[i]);
        System.out.print("}");
      return v;
   } 
   public static int productoEscalar(int [] a, int[] b){
    int pe = 0;
    for(int i=0; i<a.length; i++)
        pe += a[i]*b[i];
      return pe;
   }
   public static double moduloVector(int[] a){
      return Math.sqrt(productoEscalar(a,a));
   }
   public static double anguloVectores(int[] a, int[] b){
      int pe= productoEscalar(a, b);
      double pm= moduloVector(a)*moduloVector(b);
      return Math.toDegrees(Math.acos(pe/pm));
   }

   public static void main(String[] args){
      Scanner tec=new Scanner(System.in);
      int[] x= leeVectorInt(tec);
      int[] y= leeVectorInt(tec);

      imprimeVectorInt(x);
      System.out.printf(" de longitud %.2f\n", moduloVector(x));
      imprimeVectorInt(y);
      System.out.printf(" de longitud %.2f\n", moduloVector(y));

      if(x.length == y.length){
      System.out.printf("Producto escalar: %d\n", productoEscalar(x,y));
      System.out.printf("El ángulo de los vectores: %.2f grados\n", anguloVectores(x,y));
      }
      else System.out.print("Los vectores tienen diferentes longitudes");

   }
}
