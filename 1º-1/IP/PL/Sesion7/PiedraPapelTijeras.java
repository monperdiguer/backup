import java.util.Scanner;
public class PiedraPapelTijeras {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);

        //eleccion usuario
        System.out.printf("piedra(r), papel(p) o tijeras(s)?");
        char usuario=t.next().charAt(0);

        //eleccion ordenador
        char ordenador;
        double n=Math.random();
        //dividimos entre un tercio para que haya la misma posibilidad de eleccion
        if(n< 1.0/3)
        ordenador='r';
        else if(n<2.0/3)
        ordenador='p';
        else ordenador='s';

        System.out.printf("El ordenador escogio %s\n", ordenador);

        //escogemos al ganador
        if(usuario==ordenador)
        System.out.print("Empate");
        else if ((usuario=='r' && ordenador=='s')|| (usuario=='p' && ordenador=='r') || (usuario=='s' && ordenador=='p'))
        System.out.print("Gana el usuario");
        else System.out.print("Gana el ordenador");
        t.close();





    }
}
