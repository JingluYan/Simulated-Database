/*
 * Author:Jinglu.Yan
 * Date:2010/12/4
 * Aim:this class is a mini database, records are all saved in this calss. 
 * There are nine methods.Two of them are constructor, others four are get the value or set in this class.
 */
import java.util.*;
public class Archive
{
    static HashSet records = new HashSet();//create a new HashSet named records
    private String city;
    private int year;
    private double[] rainfallvalue;//they are different type of variavles.
    /*
     * This is a first constructor. Only give a initial values to that variables.
     */
    public Archive(){ 
        String city = "Beijing";
        int year = 2000;
        double[] rainfallvalue = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    }
    /*
     * This is the second constructor. This constructor can get the values from other class into this class to process.
     */
    public Archive(String city, int year, double[] rainfallvalue){
        this.city = city;
        this.year = year;
        this.rainfallvalue = rainfallvalue;//there are three parameters.
    }
   /*
    * This method can insert records, and it also can judge if the record has already in database.
    */
    public void insert(String city, int year){
        int c =0;
        for(Object o: records){//records set is an object o. use for sstatement to find elements in set.
            Archive a = (Archive)o;//cast object o to object a which type is Archive
            if((a.getCity()).equals(city)&&a.getYear()==year){//if there is an object which has the same city and year in set
                System.out.println("This record has already in database, old one will be rewrotten.");
                records.remove(o);//remove that record firstly
                records.add(new Archive(city,year,rainfallvalue));//rewrite that record as an object use add() 
                c=c+1;//count and judge if this if statement run
            }
        }
        if(c==0){//if that if do not run 
            records.add(new Archive(city,year,rainfallvalue));//add that record directly
        }
    }
    /*
     * This method can delete records, and judge if that record has already in database
     */
    public void delete(String city, int year){
        int c =0;
        for(Object o: records){//records set is an object o. use for sstatement to find elements in set.
            Archive a = (Archive)o;//cast object o to object a which type is Archive
            if((a.getCity()).equals(city)&&a.getYear()==year){//if there is an object which has the same city and year in set
                records.remove(o);//delete the record
            }
            c=c+1;//count and judge if this if statement run
        }
        if(c==0){//if that if do not run 
            System.out.println("That city or that year is not in database, so the records do not change.");
        }
    }
    /*
     * This method can print all records in database.
     */
    public void print(){
        getSet();//get the set firstly.
        for(Object o: records){//records set is an object o. use for sstatement to find elements in set.
            Archive s = (Archive) o;//cast object o to object a which type is Archive
            System.out.print(s.city+" ");//print city once for one object
            System.out.print(s.year+" ");//print year once for one object
            for(int n =1; n<13;n++){//print the elements in array seperately
                System.out.print(s.rainfallvalue[n]+" ");
            }
            System.out.println();
        }
    }
   /*
    * This method can get set.
    */
    public HashSet getSet(){
        return records;
    }
   /*
    * This method gets city name
    */
    public String getCity(){
        return city;
    }
   /*
    * This method gets year
    */
    public int getYear(){
        return year;
    }
   /*
    * This method gets the array
    */
    public double[] getValue(){
        return rainfallvalue;
    }
}
