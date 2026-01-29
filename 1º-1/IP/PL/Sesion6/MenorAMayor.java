import java.util.Scanner;
public class MenorAMayor {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        System.out.print("Introduce dos números reales:");
        int a=t.nextInt();
        int b=t.nextInt();
        if(a<b) System.out.printf("%d, %d\n", a, b);
        else System.out.printf("%d, %d\n", b, a);
        t.close();
    }
}
