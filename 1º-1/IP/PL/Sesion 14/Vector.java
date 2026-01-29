public class Vector{
    public static void main(String[] args){
        //Introducimos el vector
        int[] v = {5,4,3,9,0,7};

        System.out.print("Vector: {");
        for(int i=0; i<v.length;i++)
            System.out.printf("%d", v[i]);
        System.out.print("}");
    }
}