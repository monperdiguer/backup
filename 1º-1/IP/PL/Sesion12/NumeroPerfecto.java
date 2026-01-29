import java.util.Scanner;
public class NumeroPerfecto {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        System.out.print("¿Es este numero perfecto?: ");
        int n=t.nextInt();

        int sumaDivisores=0;
        for(int i=1;i<=n/2; i++) //No entiendo por qué divide el numero entre 2
            if(n%i==0) sumaDivisores+=i;
        if(n==sumaDivisores) System.out.printf("El numero %d es perfecto",n);
        else System.out.printf("El numero %d no es perfecto",n);
        t.close();
    }
}
