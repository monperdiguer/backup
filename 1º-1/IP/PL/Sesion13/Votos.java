import java.util.Scanner;
public class Votos {
    public static void main(String[] args){
        Scanner t =new Scanner(System.in);
        System.out.print("Introduce los votos de cada partido (*por cada 5000): ");
        int votos = t.nextInt();
        int partido=1;
        while(votos>=0){
            System.out.printf("partido %d: ", partido);
            int asteriscos= votos/5000;
            //Calcular los votos
            for(int columnas=1; columnas<= asteriscos; columnas++)
                System.out.print("*");
            System.out.println();
            //Siguiente elemento
            partido++;
            votos=t.nextInt();
        }
        t.close();
    }
}