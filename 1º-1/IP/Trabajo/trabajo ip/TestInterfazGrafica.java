import javax.swing.*;
import java.util.Random;

public class TestInterfazGrafica {
    public static void main(String[] args) {
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas:"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas:"));

        // Genera la matriz inicial
        int[][] matrizInicial = generarMatrizInicial(filas, columnas);

        JFrame ventana = new JFrame("Number Match - Interfaz Gráfica - Trabajo Grupal");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);

        InterfazGrafica tablero = new InterfazGrafica(filas, columnas, matrizInicial);
        ventana.add(tablero);
        ventana.setVisible(true);
    }

    private static int[][] generarMatrizInicial(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(9) + 1;
            }
        }
        return matriz;
    }
}