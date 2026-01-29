public class MediaVectorMetodo {
    public static double mediaVector(int[] v) {
        int suma=0;
        for(int i=0; i<v.length;i++)
            suma+=v[i];
        return (double)suma/v.length;
    }
    public static void main(String[] args){
        int[] v = {5, 4, 3, 9, 0, 7};

        System.out.print("Vector: {");
        for(int i=0; i<v.length;i++)
            System.out.printf("%d", v[i]);
        System.out.print("}\n");

        double media=mediaVector(v);
        System.out.printf("La media del vector  es: %f\n", media);

    }
}
