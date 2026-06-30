import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Req (4;4): Permite dibujo iterativo mediante eventos de ratón
 */
// Req (4;3): Esta clase extiende JPanel
public class FirmaPanel extends JPanel {

    //Modo de dibujo
    public enum Tool { FIRMA, CUADRADO, TRIANGULO, CIRCULO }
    private Tool tool = Tool.FIRMA;

    //Estilo
    private Color colorTrazo = Color.BLACK;
    private boolean relleno = false;

    // Firma libre: lista de trazos; cada trazo es una lista de puntos =========
    private final List<List<Point>> trazos = new ArrayList<>();
    private List<Point> trazoActual = null;

    //Figuras
    private static class Figura {
        Tool tipo;
        int initX, initY, finalX, finalY;
        Color color;
        boolean relleno;
    }

    private final List<Figura> figuras = new ArrayList<>();
    private Figura figuraPreview = null;

    public FirmaPanel() {
        setOpaque(true);
        setBackground(Color.WHITE);

        // Req (4;4): Dibujo iterativo mediante eventos de ratón
        MouseAdapter ma = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                if (tool == Tool.FIRMA) {
                    trazoActual = new ArrayList<>();
                    trazoActual.add(e.getPoint());
                    trazos.add(trazoActual);
                } else {
                    figuraPreview = new Figura();
                    figuraPreview.tipo = tool;
                    figuraPreview.initX = e.getX();
                    figuraPreview.initY = e.getY();
                    figuraPreview.finalX = e.getX();
                    figuraPreview.finalY = e.getY();
                    figuraPreview.color = colorTrazo;
                    figuraPreview.relleno = relleno;
                }

                repaint(); // repintar en cada cambio
            }

            @Override
            public void mouseDragged(MouseEvent e) {

                if (tool == Tool.FIRMA) {
                    if (trazoActual != null) {
                        trazoActual.add(e.getPoint());
                    }
                } else {
                    if (figuraPreview != null) {
                        figuraPreview.finalX = e.getX();
                        figuraPreview.finalY = e.getY();
                    }
                }

                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                if (tool == Tool.FIRMA) {
                    if (trazoActual != null) {
                        trazoActual.add(e.getPoint());
                        trazoActual = null;
                    }
                } else {
                    if (figuraPreview != null) {
                        figuraPreview.finalX = e.getX();
                        figuraPreview.finalY = e.getY();
                        figuras.add(figuraPreview);
                        figuraPreview = null;
                    }

                    tool = Tool.FIRMA;
                }

                repaint();
            }
        };

        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    //Cambia el modo a una figura
    public void setTool(Tool t) {
        if (t != null) this.tool = t;
    }

    public Tool getTool() {
        return tool;
    }

    public void setColorTrazo(Color c) {
        if (c != null) this.colorTrazo = c;
        repaint();
    }

    public Color getColorTrazo() {
        return colorTrazo;
    }

    public void setRelleno(boolean r) {
        this.relleno = r;
        repaint();
    }

    public boolean isRelleno() {
        return relleno;
    }
    
    public void limpiar() {
        trazos.clear();
        trazoActual = null;
        figuras.clear();
        figuraPreview = null;
        repaint();
    }

    public boolean hayFirma() {
        if (!figuras.isEmpty()) return true;

        for (List<Point> t : trazos) {
            if (t.size() >= 2) return true;
        }
        return false;
    }
    
    public BufferedImage snapshot() {
        BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        paint(g2);
        g2.dispose();
        return img;
    }

    //Pintado
    // Req (4;3): Sobrescribe el método paintComponent(Graphics g), es decir, paint()
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Figura f : figuras) {
            pintarFigura(g2, f);
        }
        if (figuraPreview != null) {
            pintarFigura(g2, figuraPreview);
        }
        g2.setColor(colorTrazo);
        for (List<Point> trazo : trazos) {
            for (int i = 1; i < trazo.size(); i++) {
                Point p1 = trazo.get(i - 1);
                Point p2 = trazo.get(i);
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        g2.dispose();
    }
    
    private void pintarFigura(Graphics2D g2, Figura f) {
        int initX = f.initX;
        int initY = f.initY;
        int finalX = f.finalX;
        int finalY = f.finalY;

        int bigX = Math.max(initX, finalX);
        int smallX = Math.min(initX, finalX);
        int bigY = Math.max(initY, finalY);
        int smallY = Math.min(initY, finalY);

        int width = Math.abs(bigX - smallX);
        int height = Math.abs(bigY - smallY);

        // Evita figuras "0x0"
        if (width == 0 && height == 0) return;

        Shape s = null;

        switch (f.tipo) {
            case CUADRADO:
                s = new Rectangle2D.Double(smallX, smallY, width, height);
                break;

            case CIRCULO:
                s = new Ellipse2D.Double(smallX, smallY, width, height);
                break;

            case TRIANGULO: {
                Polygon t = new Polygon();
                t.addPoint(smallX + width / 2, smallY);
                t.addPoint(smallX, smallY + height);            
                t.addPoint(smallX + width, smallY + height);    
                s = t;
                break;
            }

            default:
                return;
        }

        g2.setColor(f.color);

        // Como en el ejemplo del óvalo: primero relleno, luego borde
        if (f.relleno) g2.fill(s);
        g2.draw(s);
    }
}