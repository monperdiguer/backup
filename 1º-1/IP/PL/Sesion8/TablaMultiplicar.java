import java.util.Scanner;
public class TablaMultiplicar {
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.print("Introduzca un número entero (n):");
        int n=t.nextInt();
        for(int elemento=1; elemento<=10; elemento++){
            //Tratar elemento
            System.out.printf("%2d x %2d = %3d\n", n, elemento, n*elemento);
        }
        t.close();
    }   

    
}
