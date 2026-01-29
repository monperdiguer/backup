public class Rectangulo{
    private int X, Y, Base, Altura;

    //Constructores
    public Rectangulo(){
        setX(0);
        setY(0);
        setBase(1);
        setAltura(1);
    }
    public Rectangulo(Rectangulo r){
        setX(r.getX());
        setY(r.getY());
        setBase(r.getBase());
        setAltura(r.getAltura());
    }
    public Rectangulo(int b, int a){
        setX(0);
        setY(0);
        setBase(b);
        setAltura(a);
    }
    public Rectangulo(int x,int y,int b,int a){
        setX(x);
        setY(y);
        setBase(b);
        setAltura(a);
    }

    //Metodos
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public int getBase(){
        return Base;
    }
    public int getAltura(){
        return Altura;
    }
    public void setX(int nX){
        if(nX>=0)
            this.X= nX;
    }
    public void setY(int nY){
        if(nY>=0)
            this.Y= nY;
    }
    public void setBase(int nBase){
        if(nBase>=0)
            this.Base= nBase;
    }
    public void setAltura(int nAltura){
        if(nAltura>=0)
            this.Altura= nAltura;
    }
    
    public int calculaArea(){
        return Base*Altura;
    }
    public int calculaPerimetro(){
        return 2*Base+2*Altura;
    }
}