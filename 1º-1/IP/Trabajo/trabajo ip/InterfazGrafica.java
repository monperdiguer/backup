import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfazGrafica extends JPanel {
    private int filas;
    private int columnas;
    private TableroConsola tableroConsola;
    private int casillaSeleccionadaX = -1;
    private int casillaSeleccionadaY = -1;
    private JLabel lblVidas;
    private JLabel lblPuntos;

    public InterfazGrafica(int filas, int columnas, int[][] matrizInicial) {
        this.filas = filas;
        this.columnas = columnas;
        this.tableroConsola = new TableroConsola(filas, columnas);

        int[][] matrizConsola = tableroConsola.getMatriz();
        for (int i = 0; i < filas; i++) {
            System.arraycopy(matrizInicial[i], 0, matrizConsola[i], 0, columnas);
        }

        setLayout(new BorderLayout());

        // Panel principal para el tablero
        JPanel tableroPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarTablero(g);
            }
        };

        tableroPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                manejarClick(e.getX(), e.getY());
            }
        });
        add(tableroPanel, BorderLayout.CENTER);

        // Panel superior con información de vidas y puntos acumulados
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblVidas = new JLabel("Vidas: " + tableroConsola.getVidas());
        lblPuntos = new JLabel("Puntos: " + tableroConsola.getPuntos());
        lblVidas.setFont(new Font("Arial", Font.BOLD, 16));
        lblPuntos.setFont(new Font("Arial", Font.BOLD, 16));
        infoPanel.add(lblVidas);
        infoPanel.add(lblPuntos);
        add(infoPanel, BorderLayout.NORTH);

        // Panel de botones
        JPanel botonesPanel = new JPanel();
        JButton btnJugadaSugerida = new JButton("Jugada sugerida: ");
        JButton btnPosiblesJugadas = new JButton("Posibles jugadas");
        JButton btnAñadirNumeros = new JButton("Añadir nuevos números");
        botonesPanel.add(btnAñadirNumeros);

        // Acción para el botón de añadir nuevos números
        btnAñadirNumeros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableroConsola.añadirNumeros(); // Llama al método de consola
                actualizarInformacion(); // Actualiza vidas y puntos en la ig
                repaint(); // Redibuja el tablero
            }
        });

        botonesPanel.add(btnJugadaSugerida);
        botonesPanel.add(btnPosiblesJugadas);
        add(botonesPanel, BorderLayout.SOUTH);

        // Acción para el botón de jugada sugerida
        btnJugadaSugerida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> jugadas = tableroConsola.calcularJugadas();
                if (jugadas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay jugadas válidas disponibles.");
                } else {
                    JOptionPane.showMessageDialog(null, "Sugerencia: " + jugadas.get(0));
                }
            }
        });

        // Acción para el botón de posibles jugadas
        btnPosiblesJugadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> jugadas = tableroConsola.calcularJugadas();
                if (jugadas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay jugadas válidas disponibles.");
                } else {
                    StringBuilder jugadasTexto = new StringBuilder("Jugadas válidas posibles:\n");
                    for (String jugada : jugadas) {
                        jugadasTexto.append(jugada).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, jugadasTexto.toString());
                }
            }
        });
    }

    private void dibujarTablero(Graphics g) {
        int[][] matriz = tableroConsola.getMatriz();
        int cellWidth = getWidth() / columnas;
        int cellHeight = (getHeight() - 50) / filas; // Reserva espacio para la información

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != 0) {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
                    g.setColor(Color.WHITE);
                    g.drawString(String.valueOf(matriz[i][j]),
                            j * cellWidth + cellWidth / 2 - 5,
                            i * cellHeight + cellHeight / 2 + 5);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
                }
                g.setColor(Color.BLACK);
                g.drawRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
            }
        }
    }

    private void procesarJugada(int fila1, int columna1, int fila2, int columna2) {
        // Normaliza las coordenadas para garantizar consistencia en la jugada
        if (fila1 > fila2 || (fila1 == fila2 && columna1 > columna2)) {
            // Intercambia valores
            int tempFila = fila1;
            int tempColumna = columna1;
            fila1 = fila2;
            columna1 = columna2;
            fila2 = tempFila;
            columna2 = tempColumna;
        }

        boolean jugadaValida = tableroConsola.jugadas(fila1 + 1, columna1 + 1, fila2 + 1, columna2 + 1);

        if (jugadaValida) {
            JOptionPane.showMessageDialog(this, "¡Jugada válida!");
        } else {
            JOptionPane.showMessageDialog(this, "Jugada no válida.");
        }

        // Actualiza información y redibuja la ig
        actualizarInformacion();
        repaint();

        // Verifica si el tablero está vacío para finalizar la partida
        if (tableroConsola.tableroVacio()) {
            int puntosFinales = tableroConsola.getPuntos(); // Para obtener los puntos finales
            JOptionPane.showMessageDialog(this, "Fin de partida, has obtenido " + puntosFinales + " puntos", 
                                           "Message", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        // Verifica si el jugador quedó sin vidas
        if (tableroConsola.getVidas() <= 0) {
            JOptionPane.showMessageDialog(this, "¡Juego terminado! Te has quedado sin vidas");
        }
    }

    private void manejarClick(int x, int y) {
        int cellWidth = getWidth() / columnas;
        int cellHeight = (getHeight() - 50) / filas; // Reserva espacio para información

        int columna = x / cellWidth;
        int fila = y / cellHeight;

        // Verifica si el click está dentro del tablero
        if (fila >= filas || columna >= columnas) return;

        if (casillaSeleccionadaX == -1) {
            // Selección de la primera casilla
            casillaSeleccionadaX = columna;
            casillaSeleccionadaY = fila;
        } else {
            // Selección de la segunda casilla y procesa la jugada
            procesarJugada(casillaSeleccionadaY, casillaSeleccionadaX, fila, columna);

            // Reinicia selección
            casillaSeleccionadaX = -1;
            casillaSeleccionadaY = -1;
        }

        repaint();
    }

    private void actualizarInformacion() {
        lblVidas.setText("Vidas: " + tableroConsola.getVidas());
        lblPuntos.setText("Puntos: " + tableroConsola.getPuntos());
    }
    
}