public class Precedencia {
    public static void main(String[] args) {
        double x=2;
        double y=5;

        //Calcular las expresiones
        double resultado1=x+y/3-4*2*5/x-3;
        double resultado2=x*y+2*x/3*5+4/x-1;
        System.out.printf("La primera expersión vale: %.4f\ny la segunda expresión vale: %.4f\n", resultado1, resultado2);
    }
    
}
