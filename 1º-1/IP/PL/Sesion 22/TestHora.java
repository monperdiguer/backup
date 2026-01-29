public class TestHora {
    public static void main (String[] args){
        Hora h1=new Hora();
        Hora h2=new Hora(23);
        Hora h3=new Hora(18,45,27);
        Hora h4=new Hora(h2);

        Hora[] h={h1,h2,h3,h4};

        for(int i =0; i<h.length;i++){
            System.out.printf("Hora: %d: %d: %d (%d segundos hasta medianoche)\n",
            h[i].gethora(),
            h[i].getminutos(),
            h[i].getsegundos(),
            h[i].segundosDesdeMedianoche());
        }
    }
}
