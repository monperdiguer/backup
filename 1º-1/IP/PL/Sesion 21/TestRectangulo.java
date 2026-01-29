public class TestRectangulo {
    public static void main(String[] args){
        Rectangulo r1=new Rectangulo();
        r1.setX(3);
        r1.setY(2);
        r1.setBase(10);
        r1.setAltura(5);

        Rectangulo r2=new Rectangulo();
        r2.setX(0);
        r2.setY(0);
        r2.setBase(8);
        r2.setAltura(4);

        System.out.printf("Rectangulo r1: (%d,%d), Base=%d, Altura=%d\n",
            r1.getX(),r1.getY(),r1.getBase(),r1.getAltura());
        System.out.printf("Rectangulo r2: (%d,%d), Base=%d, Altura=%d\n",
            r2.getX(),r2.getY(),r2.getBase(),r2.getAltura());

        System.out.printf("Rectangulo r1: area=%d, perimetro=%d\n", r1.calculaArea(), r1.calculaPerimetro());
        System.out.printf("Rectangulo r2: area=%d, perimetro=%d\n", r2.calculaArea(), r2.calculaPerimetro());
        
    }
    
}
