import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TableroConsola {
    private int filas, columnas, vidas, puntos;
    private int[][] matriz;

    public TableroConsola(int filas, int columnas) {
        setFilas(filas);
        setColumnas(columnas);
        setMatriz(filas, columnas);
        setVidas(vidas = 5);
        setPuntos(puntos = 0);
    }

    public int getFilas() {
        return this.filas;
    }

    public int getColumnas() {
        return this.columnas;
    }

    public int[][] getMatriz() {
        return this.matriz;
    }

    public int getVidas() {
        return this.vidas;
    }

    public int getPuntos() {
        return this.puntos;
    }

    private void setFilas(int filas) {
        if (filas > 0)
            this.filas = filas;
    }

    private void setColumnas(int columnas) {
        if (columnas > 0)
            this.columnas = columnas;
    }

    private void setMatriz(int filas, int columnas) {
        Random r = new Random();
        this.matriz = new int[filas][columnas];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = r.nextInt(9 - 1 + 1) + 1; // Genera un número entre 1 y 9

            }
        }
    }

    private void setVidas(int vidas) {
        if (vidas <= 5)
            this.vidas = vidas;
    }

    private void setPuntos(int puntos) {
        if (puntos >= 0)
            this.puntos = puntos;
    }

    public void imprimeTablero() {
        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("%d | \t", i + 1);
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%d \t", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n   _________________________________");
        System.out.print("   \t");
        for (int z = 0; z < columnas; z++) {
            System.out.printf("%d \t", z + 1);
        }
        System.out.println("\n");
        System.out.printf("Vidas = %d\n", vidas);
        System.out.printf("Puntos = %d\n", puntos);
    }

    public boolean jugadas(int fila1, int columna1, int fila2, int columna2) {
        fila1--; columna1--; fila2--; columna2--; // Ajuste de índices para la matriz

        if (fila1 == fila2 && columna1 == columna2) {
            System.out.println("No se puede seleccionar la misma casilla dos veces. Intente de nuevo.");
            return false;
        }

        boolean jugadaRealizada = false;

        if (fila1 == fila2) {
            jugadaRealizada = checkFila(fila1, columna1, fila2, columna2);
        } else if (columna1 == columna2) {
            jugadaRealizada = checkColumna(fila1, columna1, fila2, columna2);
        } else if (Math.abs(fila1 - fila2) == Math.abs(columna1 - columna2)) {
            jugadaRealizada = checkDiagonal(fila1, columna1, fila2, columna2);
        }

        if (!jugadaRealizada) {
            System.out.println("Jugada no válida.");
            vidas--;
        }

        return jugadaRealizada;
    }

    public boolean checkFila(int fila1, int columna1, int fila2, int columna2) {
        if (fila1 != fila2) {
            return false; // Tienen que estar en la misma fila
        }

        // columna1 < columna2
        if (columna1 > columna2) {
            int temp = columna1;
            columna1 = columna2;
            columna2 = temp;
        }

        int puntosGanados = 1; // Base de la puntuación
        int casillasEnBlanco = 0;

        for (int i = columna1 + 1; i < columna2; i++) {
            if (matriz[fila1][i] != 0) {
                return false; // Hay un número entre las casillas
            }
            casillasEnBlanco++;
        }

        if (esJugadaValida(matriz[fila1][columna1], matriz[fila1][columna2])) {
            puntosGanados += 2 * casillasEnBlanco;
            puntos += puntosGanados;
            matriz[fila1][columna1] = 0;
            matriz[fila1][columna2] = 0;
            borrarFilasVacias();
            System.out.println("Jugada válida: +" + puntosGanados + " puntos. Total puntos: " + puntos);
            return true;
        }
        return false;
    }

    public boolean checkColumna(int fila1, int columna1, int fila2, int columna2) {
        if (columna1 != columna2) {
            return false; // Tienen que estar en la misma columna
        }

        // fila1 < fila2
        if (fila1 > fila2) {
            int temp = fila1;
            fila1 = fila2;
            fila2 = temp;
        }

        int puntosGanados = 1; // Base de la puntuación
        int casillasEnBlanco = 0;

        for (int i = fila1 + 1; i < fila2; i++) {
            if (matriz[i][columna1] != 0) {
                return false; // Hay un número entre las casillas
            }
            casillasEnBlanco++;
        }

        if (esJugadaValida(matriz[fila1][columna1], matriz[fila2][columna1])) {
            puntosGanados += 2 * casillasEnBlanco;
            puntos += puntosGanados;
            matriz[fila1][columna1] = 0;
            matriz[fila2][columna1] = 0;
            borrarFilasVacias();
            System.out.println("Jugada válida: +" + puntosGanados + " puntos. Total puntos: " + puntos);
            return true;
        }
        return false;
    }

    public boolean checkDiagonal(int fila1, int columna1, int fila2, int columna2) {
        if (Math.abs(fila1 - fila2) != Math.abs(columna1 - columna2)) {
            return false;
        }

        // fila1, columna1 sea el menor
        if (fila1 > fila2) {
            int temp = fila1;
            fila1 = fila2;
            fila2 = temp;

            temp = columna1;
            columna1 = columna2;
            columna2 = temp;
        }

        int puntosGanados = 1; // Base de la puntuación
        int casillasEnBlanco = 0;

        int i = fila1 + 1;
        int j = columna1 + (columna2 > columna1 ? 1 : -1);

        while (i < fila2 && j != columna2) {
            if (matriz[i][j] != 0) {
                return false; 
            }
            casillasEnBlanco++;
            i++;
            j += (columna2 > columna1 ? 1 : -1);
        }

        if (esJugadaValida(matriz[fila1][columna1], matriz[fila2][columna2])) {
            puntosGanados += 4 * casillasEnBlanco;
            puntos += puntosGanados;
            matriz[fila1][columna1] = 0;
            matriz[fila2][columna2] = 0;
            borrarFilasVacias();
            System.out.println("Jugada válida: +" + puntosGanados + " puntos. Total puntos: " + puntos);
            return true;
        }
        return false;
    }


    private boolean esJugadaValida(int valor1, int valor2) {
        return valor1 == valor2 || valor1 + valor2 == 10;
    }

    private void borrarFilasVacias() {
        List<int[]> filasNuevas = new ArrayList<>();
        for (int[] fila : matriz) {
            boolean vacia = true;
            for (int valor : fila) {
                if (valor != 0) {
                    vacia = false;
                    break;
                }
            }
            if (!vacia) {
                filasNuevas.add(fila);
            }
        }
        while (filasNuevas.size() < filas) {
            filasNuevas.add(new int[columnas]);
        }
        matriz = filasNuevas.toArray(new int[0][]);
    }

    public void añadirNumeros() {
        List<Integer> numeros = new ArrayList<>();
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor != 0) {
                    numeros.add(valor);
                }
            }
        }
        int indice = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == 0 && indice < numeros.size()) {
                    matriz[i][j] = numeros.get(indice++);
                }
            }
        }
    }

    
    public boolean tableroVacio() {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor != 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public List<String> calcularJugadas() {
        List<String> jugadas = new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != 0) {
                    buscarJugadas(i, j, jugadas);
                }
            }
        }
        return jugadas;
    }

    private void buscarJugadas(int fila, int columna, List<String> jugadas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if ((i != fila || j != columna) && matriz[i][j] != 0 &&
                        esJugadaValida(matriz[fila][columna], matriz[i][j]) &&
                        casillasIntermediasVacias(fila, columna, i, j)) {
                    jugadas.add("(" + (fila + 1) + "," + (columna + 1) + ") -> (" + (i + 1) + "," + (j + 1) + ")");
                }
            }
        }
    }

    private boolean casillasIntermediasVacias(int fila1, int columna1, int fila2, int columna2) {
        if (fila1 == fila2) {
            for (int j = Math.min(columna1, columna2) + 1; j < Math.max(columna1, columna2); j++) {
                if (matriz[fila1][j] != 0) return false;
            }
        } else if (columna1 == columna2) {
            for (int i = Math.min(fila1, fila2) + 1; i < Math.max(fila1, fila2); i++) {
                if (matriz[i][columna1] != 0) return false;
            }
        } else if (Math.abs(fila1 - fila2) == Math.abs(columna1 - columna2)) {
            int i = fila1 + (fila2 > fila1 ? 1 : -1);
            int j = columna1 + (columna2 > columna1 ? 1 : -1);
            while (i != fila2 && j != columna2) {
                if (matriz[i][j] != 0) return false;
                i += (fila2 > fila1 ? 1 : -1);
                j += (columna2 > columna1 ? 1 : -1);
            }
        } else {
            return false;
        }
        return true;
    }
    
}