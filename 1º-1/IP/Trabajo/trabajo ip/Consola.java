import java.util.Scanner;
import java.util.List;

public class Consola {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        // Solicita las dimensiones del tablero
        System.out.println("Introduzca el número de filas y de columnas: ");
        int filas = tec.nextInt();
        int columnas = tec.nextInt();

        TableroConsola t = new TableroConsola(filas, columnas);

        // Muestra el tablero inicial
        System.out.println("\nTablero inicial:");
        t.imprimeTablero();

        // Loop principal del juego
        while (t.getVidas() > 0) {
            // Finaliza automáticamente si el tablero está vacío
            if (t.tableroVacio()) {
                System.out.println("¡El tablero está vacío! Fin del juego.");
                break;
            }

            // Pregunta si el usuario desea una sugerencia de jugada válida
            System.out.println("¿Desea una sugerencia de jugada válida? (si/no): ");
            tec.nextLine(); // Limpiar el buffer
            String respuesta = tec.nextLine().trim().toLowerCase();

            if (respuesta.equals("si")) {
                List<String> posiblesJugadas = t.calcularJugadas();
                if (posiblesJugadas.isEmpty()) {
                    System.out.println("No hay jugadas válidas disponibles.");
                } else {
                    System.out.println("Jugadas válidas posibles: " + posiblesJugadas);
                    System.out.println("Sugerencia: " + posiblesJugadas.get(0));
                }
            }

            // Solicita al usuario una jugada
            System.out.println("Introduzca la fila y columna de la primera casilla (fila columna): ");
            int fila1 = tec.nextInt();
            int columna1 = tec.nextInt();
            System.out.println("Introduzca la fila y columna de la segunda casilla (fila columna): ");
            int fila2 = tec.nextInt();
            int columna2 = tec.nextInt();

            // Intenta realizar la jugada para ver si es valida o no
            boolean jugadaValida = false;
            if (fila1 > 0 && fila1 <= filas && columna1 > 0 && columna1 <= columnas &&
                fila2 > 0 && fila2 <= filas && columna2 > 0 && columna2 <= columnas) {
                jugadaValida = t.jugadas(fila1, columna1, fila2, columna2);
                if (!jugadaValida) {
                    System.out.println("\nJugada no válida. Pierdes una vida.");
                    System.out.println("Vidas restantes: " + t.getVidas());
                }
            } else {
                System.out.println("Coordenadas fuera de rango. Intente nuevamente.");
            }

            // Muestra el tablero actualizado después de cada jugada
            System.out.println("\nTablero actualizado:");
            t.imprimeTablero();

            // Verifica si quedan jugadas válidas
            List<String> posiblesJugadas = t.calcularJugadas();
            if (posiblesJugadas.isEmpty()) {
                // Finaliza automáticamente el juego si el tablero está vacío
                if (t.tableroVacio()) {
                    System.out.println("¡El tablero está vacío! Fin del juego.");
                    break;
                }

                System.out.println("No hay más jugadas posibles.");
                System.out.println("¿Desea añadir más números al tablero? (si/no): ");
                tec.nextLine(); // Limpia el buffer
                respuesta = tec.nextLine().trim().toLowerCase();

                if (respuesta.equals("si")) {
                    t.añadirNumeros();
                    System.out.println("\nTablero tras añadir números:");
                    t.imprimeTablero();
                } else {
                    System.out.println("Juego terminado.");
                    break;
                }
            }
        }

        // Muestra la puntuación final
        System.out.println("Fin de partida, has obtenido " + t.getPuntos() + " puntos.");
        tec.close();
    }
}