public class MediaVector {
    public static void main(String[] args){
        //Introducimos el vector
        int[] v = {5, 4, 3, 9, 0, 7};

        System.out.print("Vector: {");
        for(int i=0; i<v.length;i++)
            System.out.printf("%d", v[i]);
        System.out.print("}\n");


        int suma=0;
        for(int i=0; i<v.length;i++)
            suma+=v[i];
        double media=(double)suma/v.length;
        System.out.printf("La media del vector  es: %f\n", media);

    }
}
