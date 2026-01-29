import java.util.Scanner;
public class ST {

    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        System.out.println("Introduce la velocidad del viento(m/s):");
        double v = teclado.nextDouble();
        System.out.println("Introduce la temperatura(celsius):");
        double T = teclado.nextDouble();

        //Fórmula de Siple
        double st_siple = -0.04544*(10.45+10*Math.sqrt(v)-v)*(33-T)+33;
        //Formula moderna
        double st_moderna=13.12+0.6215*T+(0.3965*T-11.37)*Math.pow(v,0.16);
        System.out.printf("Sensación térmica:\n- Siple:%.2f\n- Moderna:%.2f\n",st_siple, st_moderna);
        teclado.close();

    }
}
