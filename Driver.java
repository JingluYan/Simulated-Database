/*
 * Author:Jinglu.Yan
 * Date:2010/12/4
 * Aim:This Java program is handling a kind of small data base system. This Java code provides operations for inserting, extracting, deleting and displaying information from the system.
 * This is Driver class which contains only one method to control all process
 * There are three classes in this program.
 */
import java.util.*;
public class Driver{
    public static String city = "";
    public static int year = 0;
    public static double[] rainfallvalue = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    /*
     * This is main class.It is the begining for every program.
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to do now?");
        System.out.println("Insert record---1                Delete record---2                        Print records---3");
        System.out.println("Insert value---4                 Insert a quarter value---5               Delete value---6");
        System.out.println("Calculate average value---7      Find one month rainfall value---8        Find wettest month---9");
        System.out.println("*****************************************************************************************************");
        System.out.println("If you need to input Month, please input like this:");
        System.out.println("Jan   Feb   Mar   Apr   May   Jun   Jul   Aug   Sep   Oct   Nov   Dec");
        System.out.println("*****************************************************************************************************");
        while(true){//loop this procee many times
            System.out.print("You choose: ");
            int choose = input.nextInt();
            if(choose==1||choose==2||choose==3||choose==4||choose==5||choose==6||choose==7||choose==8||choose==9){
                if(choose==1){
                    double[]rainfallvalue = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
                    System.out.print("City Name: ");
                    String city = input.next();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    for(int n=1; n<13;n++){
                        System.out.print("The value of the " +n+"th month: ");
                        double rainfall = input.nextDouble();
                        rainfallvalue[n] = rainfall;//input values in array
                    }
                    Archive A = new Archive(city, year, rainfallvalue);
                    A.insert(city, year);//call insert method from Archive class
                }
                if(choose==2){
                    System.out.print("City Name: ");
                    String city = input.next();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    Archive A =new Archive(city, year, rainfallvalue);
                    A.delete(city,year);//call delete method from Archive class
                }
                if(choose==3){
                    Archive A =new Archive(city, year, rainfallvalue);
                    A.print();//call pring method from Archive class
                }
                if(choose==4){
                    System.out.print("City Name: ");
                    String city = input.next();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    System.out.print("Month: ");
                    String month = input.next();
                    if(month.equals("Jan")||month.equals("Feb")||month.equals("Mar")||month.equals("Apr")||month.equals("May")||month.equals("Jun")||month.equals("Jul")||month.equals("Aug")||month.equals("Sep")||month.equals("Oct")||month.equals("Nov")||month.equals("Dec")){
                        System.out.print("Value: ");
                        double value = input.nextDouble();
                        RainFallRecord R = new RainFallRecord(city, year, rainfallvalue);
                        R.insert(month,value);//call insert method from RainFallRecord class
                    }
                    else{
                        System.out.println("Please input month in right way!");//if user input a wrong month
                    }
                }
                if(choose==5){
                    System.out.print("City Name: ");
                    String city = input.next();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    System.out.print("Which quarter(one,two,three,four): ");
                    String quarter = input.next();
                    System.out.print("Input the first value in this quarter: ");
                    double first = input.nextDouble();
                    System.out.print("Input the second value in this quarter: ");
                    double second = input.nextDouble();
                    System.out.print("Input the third value in this quarter: ");
                    double third = input.nextDouble();
                    double[] value = {first, second, third};//new array to save three values
                    RainFallRecord R = new RainFallRecord(city, year, rainfallvalue);
                    R.insert(quarter, value);//call insert method from RainFallRecord class
                }
                if(choose==6){
                    System.out.print("City Name: ");
                    String city = input.next();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    System.out.print("Month: ");
                    String month = input.next();
                    if(month.equals("Jan")||month.equals("Feb")||month.equals("Mar")||month.equals("Apr")||month.equals("May")||month.equals("Jun")||month.equals("Jul")||month.equals("Aug")||month.equals("Sep")||month.equals("Oct")||month.equals("Nov")||month.equals("Dec")){
                        RainFallRecord R = new RainFallRecord(city, year, rainfallvalue);
                        R.delete(month);//call delete method from RainFallRecord class
                    }
                    else{
                        System.out.println("Please input month in right way!");
                    }
                }
                if(choose==7){
                    System.out.print("City Name: ");
                    String city = input.next();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    System.out.print("First Month: ");
                    String firstmonth = input.next();
                    System.out.print("Last Month: ");
                    String lastmonth = input.next();
                    if(firstmonth.equals("Jan")||firstmonth.equals("Feb")||firstmonth.equals("Mar")||firstmonth.equals("Apr")||firstmonth.equals("May")||firstmonth.equals("Jun")||firstmonth.equals("Jul")||firstmonth.equals("Aug")||firstmonth.equals("Sep")||firstmonth.equals("Oct")||firstmonth.equals("Nov")||firstmonth.equals("Dec")||lastmonth.equals("Jan")||lastmonth.equals("Feb")||lastmonth.equals("Mar")||lastmonth.equals("Apr")||lastmonth.equals("May")||lastmonth.equals("Jun")||lastmonth.equals("Jul")||lastmonth.equals("Aug")||lastmonth.equals("Sep")||lastmonth.equals("Oct")||lastmonth.equals("Nov")||lastmonth.equals("Dec")){
                        RainFallRecord R = new RainFallRecord(city, year, rainfallvalue);
                        System.out.println("The average rainfall value in "+city+" in "+year+" is "+R.average(city, year, firstmonth, lastmonth));//call average method from RainFallRecord class
                    }
                    else{
                        System.out.println("Please input month in right way!");
                    }
                }
                if(choose==8){
                    System.out.print("City Name: ");
                    String city = input.next();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    System.out.print("Month: ");
                    String month = input.next();
                    if(month.equals("Jan")||month.equals("Feb")||month.equals("Mar")||month.equals("Apr")||month.equals("May")||month.equals("Jun")||month.equals("Jul")||month.equals("Aug")||month.equals("Sep")||month.equals("Oct")||month.equals("Nov")||month.equals("Dec")){
                        RainFallRecord R = new RainFallRecord(city, year, rainfallvalue);
                        System.out.println("The rainfall value in "+city+" in "+month+" "+year+" is "+R.rainfall(month));//call rainfall method from RainFallRecord class
                    }
                    else{
                        System.out.println("Please input month in right way!");
                    }
                }
                if(choose==9){
                    System.out.print("City Name: ");
                    String city = input.next();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    RainFallRecord R = new RainFallRecord(city, year, rainfallvalue);
                    System.out.println("In "+city+", the wettest month in "+year+" is "+R.wettest());//call wettest method from RainFallRecord class
                }
                System.out.print("If you want to stop, input No. Otherwise, input anything: ");
                String answer = input.next();
                if(answer.equals("No")){
                    System.exit(0);//stop this program
                }
            }
            else{
                System.out.println("You choose is wrong, please try again!");//if input a wrong choice 
            }
        }
    }
}

