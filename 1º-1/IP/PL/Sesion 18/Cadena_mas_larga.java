import java.util.Scanner;
public class Cadena_mas_larga {
    public static void main(String [] args){
        Scanner t=new Scanner(System.in);
        System.out.println("Introduce 5 palabras");
        String[] v=new String[5];
        for(int i=0; i<v.length;i++)
            v[i]=t.next();
        
        String masLarga=v[0];
        for(int i=1; i<v.length;i++){
            if(v[i].length()>masLarga.length())
                masLarga=v[i];
        }
        System.out.printf("La más larga es: %s",masLarga);
        t.close();
    }

}
