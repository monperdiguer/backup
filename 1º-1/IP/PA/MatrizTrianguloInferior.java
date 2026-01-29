public class MatrizTrianguloInferior {
    public static int[] trianguloInferior(int[][] matriz){
        int dimension=(matriz.length*matriz.length-matriz.length)/2;//La dimension del triangulo de una matriz unicamente
        int[] vector=new int[dimension];
        int i=0;
        for(int filas=1;filas<matriz.length;filas++){ //Empieza en 1 porque la primera fila no se encuentra en el triangulo inferior
            for(int columnas=0;columnas<matriz[filas].length;columnas++){
                vector[i]=matriz[filas][columnas];
                i++;
            }
        }
        for(int j=0;j<vector.length;j++)
            System.out.printf("%d ",vector[j]);
        return vector;
    }
    public static void main(String[] args){
        int[][] matriz={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        System.out.println("El triangulo inferior de la matriz es: \n");
        trianguloInferior(matriz);
    }
}
//???!!!