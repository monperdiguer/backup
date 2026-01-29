import java.util.Scanner;
public class Mayusculas {
    public static void main(String[] args){
        Scanner t=new Scanner(System.in);
        System.out.println("Palabra: ");
        String palabra=t.next();

        for(int i=0;i<palabra.length();i++){
            char letra=palabra.charAt(i);
            if(letra >= 'a' && letra<='z')
                letra=(char)(letra-32);
            System.out.printf("%c",letra);

        }
        t.close();
    }
}
