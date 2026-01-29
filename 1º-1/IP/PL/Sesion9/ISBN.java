import java.util.Scanner;
public class ISBN {
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Ingrese un número ISBN de 10 dígitos: ");
        long ISBN=t.nextLong();
        int suma=0;
        int factor=1;
        while(ISBN>0){
            //Obtener el último digito
            int digito=(int)(ISBN%10);
            suma += digito * factor;
            //Borramos el ultimo digito
            ISBN/=10;
            factor++;
        }
        // Verificar si la suma es múltiplo de 11
        if (suma % 11 == 0) {
            System.out.println("El código ISBN es válido");
        } else {
            System.out.println("El código ISBN %f no es válido");
        }
        t.close();
    }
}
