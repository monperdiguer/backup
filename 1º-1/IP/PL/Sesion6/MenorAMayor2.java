import java.util.Scanner;
public class MenorAMayor2 {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce tres números reales:");
        int a=t.nextInt();
        int b=t.nextInt();
        int c=t.nextInt();
        if(a<b)
            if(b<c) System.out.printf("%d, %d, %d\n", a, b, c);
            else if (a<c) System.out.printf("%d, %d, %d\n", a, c, b);
            else System.out.printf("%d, %d, %d\n", c, a, b);
        else if(a<c)
        System.out.printf("%d, %d, %d\n", b, a, c);
        else if(b<c)
        System.out.printf("%d, %d, %d\n", b, c, a);
        else
        System.out.printf("%d, %d, %d\n", c, b, a);
        t.close();
    }
    
}
