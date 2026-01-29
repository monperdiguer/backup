import java.util.Scanner;
public class Valle {
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce la secuencia de numeros enteros positivos: ");
        int n=t.nextInt();
        int m=t.nextInt();
        int p=t.nextInt();
        while(n>=0){
            if((n>m) && (m<p))
                System.out.print("Hay un valle");
            else{
                m=n;
                p=m;
                n=t.nextInt();
            }
            
        }
        System.out.print("No hay un valle");
        t.close();
    }
}
//NO FUNIONA!!!!