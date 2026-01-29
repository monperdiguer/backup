import java.util.Scanner;
public class mcm {
    public static int MDC(int primer_elemento, int segundo_elemento){
        while(segundo_elemento!=0){
            int temp=segundo_elemento;
            segundo_elemento=primer_elemento%segundo_elemento;
            primer_elemento=temp;
        }
        return primer_elemento;
    }
    public static int calculomcm(int primer_elemento, int segundo_elemento){
        return(primer_elemento*segundo_elemento)/MCD(primer_elemento, segundo_elemento);
    }
    public static void main(String[] args){
        Scanner t =new Scanner(System.in);
        int primer_elemento=t.nextInt();
        int segundo_elemento=t.nextInt();
        int mcm=calculomcm(primer_elemento, segundo_elemento);
        System.out.printf("El mcm de %f y %f es: %f\n", primer_elemento, segundo_elemento, mcm);
        t.close();
    }
}
