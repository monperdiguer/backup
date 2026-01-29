import java.util.Scanner;
public class ProductoPares {
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        double contador=1; //para la multiplicacion
        double par=1; //para coger la posicion par
        System.out.print("Introduzca la secuencia de números enteros: ");
        double n=t.nextDouble();
        while(n!=0){
            if(par%2==0){
                contador*=n;
            }
        n=t.nextDouble();
        par++;
        }
        System.out.printf("La multiplicación de las posiciones pares son: %.1f\n", contador);
        t.close();
    }  
}
