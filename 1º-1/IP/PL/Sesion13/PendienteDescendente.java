import java.util.Scanner;
public class PendienteDescendente {
    public static void main(String[] args){
        Scanner t =new Scanner(System.in);
        System.out.print("Introduce la altura de la figura: ");
        int n = t.nextInt();

        for(int fila =1; fila<=n; fila++){

            //Impresion de la altura
            for(int columna=1; columna<=fila; columna++)
                System.out.print("*");
            System.out.println();
        }
        t.close();
    }
}
