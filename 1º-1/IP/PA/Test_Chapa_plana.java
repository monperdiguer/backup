public class Test_Chapa_plana {
    public static void main(String[] args) {
        Chapa_Plana cp1= new Chapa_Plana(10,19,1);
        Chapa_Plana cp2= new Chapa_Plana(1000);
        Chapa_Plana cp3= new Chapa_Plana();
        Chapa_Plana cp4= new Chapa_Plana(cp1);

        Chapa_Plana[] cp ={cp1,cp2,cp3,cp4};
        for(int i=0; i<cp.length;i++){
        System.out.printf("Chapa plana %s: Ancho=%s, Largo=%s, Espesor=%s\n Volumen=%.04s, Peso=%.04s ¿%s %s es más pesado que %s?\n", 
        i+1,
        cp[i].getAncho(),
        cp[i].getLargo(),
        cp[i].getEspesor(),
        cp[i].calculaVolumen(),
        cp[i].calculaPeso(),
        cp[i],(cp[i].esMasPesado(cp[i+1]) ? "SI" : "NO"),cp[i]);
        }
    }
}
