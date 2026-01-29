public class NumeroPerfectoIntervalo2 {
    public static boolean perfecto(int num){
        int suma=0;
        for(int i=1; i<=num/2;i++)
        if (num%i==0) suma+=i;
        return suma==num;
    }
    
    public static void main(String[] args) {
        System.out.print("En el intervalo [1,10000]\n");
        for(int n=1;n<=10000; n++){
            if(perfecto(n))
            System.out.printf("El numero %d es perfecto\n",n);
            //else
        //  System.out.printf("El numero %d no es perfecto",n);
        }
        
    }
}
