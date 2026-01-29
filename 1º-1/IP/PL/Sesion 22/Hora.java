public class Hora {
    private int hora,minutos,segundos;
    //Constructores
    public Hora(){
        sethora(0);
        setminutos(0);
        setsegundos(0);
    }
    public Hora(Hora h){
        sethora(h.gethora());
        setminutos(h.getminutos());
        setsegundos(h.getsegundos());
    }
    public Hora(int h){
        sethora(h);
        setminutos(0);
        setsegundos(0);
    }
    public Hora(int h, int m, int s){
        sethora(h);
        setminutos(m);
        setsegundos(s);
    }

    //Metodos
    public int gethora(){
        return hora;
    }
    public int getminutos(){
        return minutos;
    }
    public int getsegundos(){
        return segundos;
    }
    public void sethora(int nhora){
        if(nhora>=0 && nhora<24)
            this.hora=nhora;
    }
    public void setminutos(int nminutos){
        if(nminutos>=0 && nminutos<60)
            this.minutos=nminutos;
    }
    public void setsegundos(int nsegundos){
        if(nsegundos>=0 && nsegundos<=60)
            this.segundos=nsegundos;
    }
    public int segundosDesdeMedianoche(){
        return gethora() *3600+getminutos()*60+getsegundos();
    }
    
}
