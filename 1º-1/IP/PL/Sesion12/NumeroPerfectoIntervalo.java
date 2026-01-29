public class NumeroPerfectoIntervalo {
    public static void main(String[] args) {
        System.out.print("En el intervalo [1,10000]\n");
        for(int n=1;n<=10000; n++){
            int sumaDivisores=0;
            for(int i=1;i<=n/2;i++)
            if(n%i==0) sumaDivisores+=i;
        if(n==sumaDivisores) System.out.printf("El numero %d es perfecto\n",n);
        //else
        //  System.out.printf("El numero %d no es perfecto",n);
    }
}
}