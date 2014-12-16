/*
 * Author:Jinglu.Yan
 * Date:2010/12/4
 * Aim:This class can calculate average value and find the wettest month. It also can change single value in records.
 * There are eight methods.
 */
import java.util.*;
public class RainFallRecord
{
    private String city;
    private int year;
    private double[] rainfallvalue;//they are different type of variables.
    private static String months[] = {"Unk", "Jan", "Feb", "Mar", "Apr","May", "Jun", "Jul", "Aug","Sep", "Oct", "Nov", "Dec"};
    Archive A = new Archive(city, year,rainfallvalue);//connect with Archive class. A is an object for Archive
    /*
     * This is the first constructor.Only give a initial values to that variables.
     */
    public RainFallRecord(){
        String city = "Beijing";
        int year = 2000;
        double[] rainfallvalue = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    }

    /*
     * This is the second constructor. This constructor can get the values from other class into this class to process.
     */
    public RainFallRecord(String city, int year, double[] rainfallvalue){
        this.city = city;
        this.year = year;
        this.rainfallvalue = rainfallvalue;
    }

    /*
     * This method calculates average value, and judges if that record in database.
     */
    public double average(String city, int year,String firstmonth, String lastmonth){
        HashSet records = A.getSet();
        double sum = 0.0;
        int first=0, last=0;
        int c=0;//they are different type of variables, and give a initial values to that variables.
        for(Object o: records){//records set is an object o. use for sstatement to find elements in set.
            Archive a = (Archive) o;//cast object o to object a which type is Archive
            double[] value = a.getValue();//get array values from Archive class
            for(int m=0; m<13;m++){//loop 12 times
                if(firstmonth.equals(months[m])){//find the String month position to get the integer
                    first = m;//find the first month from String to integer
                }
            }
            for(int z=0;z<13;z++){
                if(lastmonth.equals(months[z])){
                    last = z;//find the second month from String to integer 
                }
            }
            if((a.getCity()).equals(city)&&a.getYear()==year){
                for(int n=first; n<last+1;n++){
                    sum = sum + value[n];//add all elements in array
                }
                c=c+1;//judge if this if process
            }
        }
        if(c==0){//if that judge does not process
            System.out.println("Sorry. That city or that year is not in database.Average value can not be calculated.");
        }
        return sum/(last-first+1);//return average value
    }

    /*
     * This method can find the right value, and judges if that record in database.
     */
    public double rainfall(String month){
        HashSet records = A.getSet();//get set from Archive class
        double rainfall =0.0;
        int c=0;
        for(Object o: records){
            Archive  a = (Archive ) o;
            double[] value = a.getValue();
            if((a.getCity()).equals(city)&&a.getYear()==year){
                for(int n=0; n<13;n++){
                    if(month.equals(months[n])){//find the right position to find the corresponding value
                        rainfall =  value[n];//give the value to rainfall variable
                    }
                }
                c=c+1;
            }
            if(c==0){
                System.out.println("Sorry. That city or that year is not in database. Cannot find the right value.");
            }
        }
        return rainfall;//return the right value

    }
    /*
     * This method can delete single value in records, and judges if that record in database.
     */
    public void delete(String month){
        HashSet records = A.getSet();
        int c = 0;
        for(Object o: records){
            Archive a = (Archive)o;
            double[] value = a.getValue();
            if((a.getCity()).equals(city)&&a.getYear()==year){
                for(int n=0; n<13;n++){
                    if(month.equals(months[n])){
                        value[n] = 0.0;//give 0.0 to that value in order to let use know that value has been deleted
                    }
                }
                c=c+1;
            }
        }
        if(c==0){
            System.out.println("Sorry. That city or that year is not in database. Nothing is changed in database.");
        }

    }
    /*
     * This method can insert single value in records, and judges if that record in database.
     */
    public void insert(String month, double value){
        HashSet records = A.getSet();
        int c=0;
        for(Object o: records){
            Archive a = (Archive)o;
            double[] value1 = a.getValue();
            if((a.getCity()).equals(city)&&a.getYear()==year){
                for(int n=0; n<13;n++){
                    if(month.equals(months[n])){
                        value1[n] = value;//give(insert) the parameter value to that value in record
                    }
                }
                c=c+1;
            }
        }
        if(c==0){
            System.out.println("Sorry. That city or that year is not in database. Nothing is changed in database.");
        }

    }
    /*
     * This method inserts value by quarter,and judges if that record in database.
     */
    public void insert(String quarter, double[] value){
        HashSet records = A.getSet();
        int c=0;
        for(Object o: records){
            Archive a = (Archive)o;
            double[] value1 = a.getValue();
            if(quarter.equals("one")||quarter.equals("two")||quarter.equals("three")||quarter.equals("four")){//if user input the right quarter
                if((a.getCity()).equals(city)&&a.getYear()==year){
                    if(quarter.equals("one")){
                        for(int n=1; n<4; n++){
                            value1[n]=value[n-1];//rewrite the first quarter value
                        }
                    }
                    if(quarter.equals("two")){
                        for(int n=4; n<7; n++){
                            value1[n]=value[n-4];//rewrite the second quarter value
                        }
                    }
                    if(quarter.equals("three")){
                        for(int n=7; n<10; n++){
                            value1[n]=value[n-7];//rewrite the third quarter value
                        }
                    }
                    if(quarter.equals("four")){
                        for(int n=10; n<13; n++){
                            value1[n]=value[n-10];//rewrite the fourth quarter value
                        }
                    }
                    c=c+1;
                }
            }
            else{//user input wrong quarter
                System.out.println("Sorry, only one, two, three, four are allowed.");
            }
        }
        if(c==0){
            System.out.println("Sorry, that city or that year is not in database. Therefore, there is no change.");

        }
    }
    /*
     * This method finds wettest month, and judges if that record in database.
     */
    public String wettest(){
        HashSet records = A.getSet();
        double wettest = rainfallvalue[0];
        int numbermonth = 0;
        int c=0;
        for(Object o: records){
            Archive a = (Archive)o;
            double[] value = a.getValue();
            if((a.getCity()).equals(city)&&a.getYear()==year){
                for(int n=1; n<13; n++){
                    wettest = Math.max(value[n],wettest);//find the maximum value in array
                }
                for(int m=0;m<13; m++){
                    if(wettest==value[m]){
                        numbermonth = m;//find corresponding position to two array
                    }
                }
                c=c+1;
            }
        }
        if(c==0){
            System.out.println("Sorry. That city or that year is not in database. Cannot find the right month.");
        }
        return months[numbermonth];//return the String in months array
    }
}
