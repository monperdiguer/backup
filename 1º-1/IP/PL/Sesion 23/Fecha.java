/**
 * Clase para representar fechas
 * 
 * @author Mónica Perdiguer
 */

public class Fecha{
    /**atributos para almacenar el día, el mes y el año de la fecha */
    private int dia=1, mes=1, año=1900;

    //Constructores
    /**
     * Crea una fecha y establece sus datos con los parámetros indicados, es decir,
     * dia/mes/año
     * 
     * @param año es el año
     * @param mes es el mes
     * @param dia es el día del mes
     */

    public Fecha(int dia, int mes, int año){
        //Importante el orden
        setAño(año);
        setMes(mes);
        setDia(dia);
    }
    /**
     * Crea  una fecha con el dia 1 de enero del año que se pasa como parámetro
     * @param año es el año de la fecha
     */
    public Fecha(int año){
        this(1,1,año);
    }
    /**
     * Crea una fecha idéntica a la que se pasa como parámetro
     * @param f es la fecha de la que se copiarán los datos (dia, mes y año)
     */
    public Fecha(Fecha f){
        this(f.getDia(),f.getMes(), f.getAño());
    }

    //Metodos
    /**
     * @return el día de la fecha
     */
    public int getDia(){
        return dia;
    }
    /**
     * Establece un día válido, teniendo en cuenta el mes y el año,
     * que ya deben estar establecidos previamente
     * @return nDia es el día que se pretende establecer
     */
    public void setDia(int nDias){
        boolean esBisiesto=(getAño()%4==0 && (getAño()%100!=0 || getAño()%400==0));
        int[] dias={31, (esBisiesto?29:28), 31,30,31,30,31,31,30,31,30,31};
        int utimoDia=dias[getMes()-1];
        if(nDias>0 && nDias<=utimoDia)
            dia=nDias;
    }
    /**
     * @return el mes de la fecha
     */
    public int getMes(){
        return mes;
    }
    /**
     * Establece un mes válido, que pueda estar entre 1 y 12 incluidos
     * @param nMes
     */
    public void setMes(int nMes){
        if(nMes>=1 && nMes<=12)
            mes=nMes;
    }
    /**
     * @return el año de la fecha
     */
    public int getAño(){
        return año;
    }
    /**
     * Establece un año válido, que sea positivo
     * @param nAño
     */
    public void setAño(int nAño){
        if(nAño>0)
            año=nAño;
    }
    /**
     * Sirve para coparar dos fechas y determinar si una es anterior a otra
     * @param f es la fecha con la que comparar el objeto actual
     * @return true si el objeto representa una fecha anterior a f,
     * y false en caso contrario
     */
    public boolean esAnterior(Fecha f){
        if(getAño()<f.getAño())
         return true;
        if (getAño()==f.getAño() && getMes()< f.getMes())
            return true;
        if(getAño()==f.getAño() && getMes()==f.getMes() && getDia()<f.getDia())
            return true;
        
        return false;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj instanceof Fecha){
          Fecha f=(Fecha) obj;
            return (getAño()==f.getAño() && getMes()==f.getMes() && getDia()==f.getDia());
        }
        else return false;
    }
    @Override
    public String toString(){
        return String.format("%02d/%02d/%04d", getDia(), getMes(), getAño());
    }
}