public class TestRectangulo {
    public static void main(String[] args){
        Rectangulo r1=new Rectangulo();
        Rectangulo r2=new Rectangulo(10,20);
        Rectangulo r3= new Rectangulo(2,3,8,2);
        Rectangulo r4= new Rectangulo(r2);

        Rectangulo[]r={r1,r2,r3,r4};

        for(int i=0;i<r.length;i++){
            System.out.printf("Rectangulo %d: (%d,%d), Base=%d, Altura=%d, Area=%d, Perimetro=%d\n",
                i+1,
                r[i].getX(),
                r[i].getY(),
                r[i].getBase(),
                r[i].getAltura(),
                r[i].calculaArea(),
                r[i].calculaPerimetro());

        }
        
    }
    
}
