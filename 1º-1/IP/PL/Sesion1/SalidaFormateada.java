public class SalidaFormateada {
    public static void main(String[] args) {
        String cadena = "X vale: " , cadena2 = "Y vale: " ;
        int x, x2=9;
        double y;

        x=35;
        y= (double) x / x2; // hace que la division salga decimal

        System.out.print(cadena);
        System.out.println(x);
        System.out.print(cadena2);
        System.out.println(y);
    }
}
