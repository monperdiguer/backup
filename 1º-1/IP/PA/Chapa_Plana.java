public class Chapa_Plana {
    private double Ancho, Largo, Espesor;

    //Construstores
    public Chapa_Plana(double Ancho, double Largo, double Espesor){
        setAncho(Ancho);
        setLargo(Largo);
        setEspesor(Espesor);
    }
    public Chapa_Plana(double Largo){
        this(250,Largo,1);
    }
    public Chapa_Plana( Chapa_Plana cp){
        this(cp.getAncho(), cp.getLargo(), cp.getEspesor());
    }
    public Chapa_Plana(){
        this(250,1200,1);
    }
    //Métodos
    public void setAncho(double nAncho){
        if(nAncho>0)
            this.Ancho=nAncho;
    }
    public double getAncho(){
        return this.Ancho;
    }
    public void setLargo(double nLargo){
        if(nLargo>0)
            this.Largo=nLargo;
    }
    public double getLargo(){
        return this.Largo;
    }
    public void setEspesor(double nEspesor){
        if(nEspesor>0)
            this.Espesor=nEspesor;
    }
    public double getEspesor(){
        return this.Espesor;
    }
    public double calculaVolumen(){
        return Ancho*Largo*Espesor;
    }
    public double calculaPeso(){
        double densidad= 7800*10^(-6);
        return calculaVolumen()*densidad;
    }
    public boolean esMasPesado(Chapa_Plana cp){
        if(this.calculaPeso()>cp.calculaPeso()) return true;
        else return false;
    }
    
}
