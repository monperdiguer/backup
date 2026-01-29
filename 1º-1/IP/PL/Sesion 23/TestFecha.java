public class TestFecha{
    public static void main(String[] args){
        Fecha f1=new Fecha(2002);
        Fecha f2=new Fecha(15,7,1975);
        Fecha f3=new Fecha(f2);


        System.out.printf("Fechas: \n%s\n%s\n%s\n",f1,f2,f3);

        System.out.printf("%s %s es anterior a %s\n",
        f2,(f2.esAnterior(f1) ? "SI" : "NO"), f1);
        System.out.printf("%s %s es anterior a %s\n",
        f1,(f1.esAnterior(f3) ? "SI" : "NO"), f3);

        if(f1.equals(f2))
            System.out.printf("%s y %s son iguales\n",f1,f2);
        if(f3.equals(f2))
            System.out.printf("%s y %s son iguales\n",f3,f2);

        //Prueba fecha incorrecta
        Fecha f4= new Fecha(29,2,1900);
        System.out.println(f4);
        f4.setAño(2000);
        System.out.println(f4);
    }
}