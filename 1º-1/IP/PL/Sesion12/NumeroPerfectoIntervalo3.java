import java.util.Scanner;
public class NumeroPerfectoIntervalo3 {
    public static boolean perfecto(int num){
        int suma=0;
        for(int i=1; i<=num/2;i++)
        if (num%i==0) suma+=i;
        return suma==num;
    }
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Introduzca el intervalo: ");
        int primer=t.nextInt();
        int segundo=t.nextInt();

        int i=primer;
        while((i<=segundo) && !perfecto(i))
            //Obtener siguiente elemento
            i++;

        //Si NO final de secuencia
        if(i<=segundo)
            System.out.printf("Hay numeros perfectos, por ejemplo %d\n", i);   
        else System.out.print("No hay numeros perfectos en ese intervalo");
        t.close(); 
    }
    
}