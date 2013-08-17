//DAY OF THE WEEK

//30 days: september, april, june, november, 
//28 days (in common years): Febraury
//29 days (in leap years): February
import java.io.*;
import java.util.Date;

public class Doy{
	
	private int [] thirthy = {4,6,9,11}; //September, April, June, November,
	private int [] thirthyOne = {1,3,5,7,8,10,12}; //January, March, May, July, August, October, December
	
	public Doy() {
		
	}

	boolean isleapYear(int year){
		//error check - year
		if(year<= 0){
			throw new RuntimeException("the year entered is not valid");
			//or simply return 0
		}

		//leap year test
		if ((year%400)==0) return true;
		else if ((year%100)==0) return false;
		else if ((year%4)==0) return true;
		else return false;

	}

	public static void main(String[] args) {
		int reqArgsCount=3;
		boolean entryInvalid=true;
		
		System.out.println("\t###################################");
		System.out.println("\t\tDAY OF THE WEEK FINDER");
		System.out.println("\t###################################\n");
		Doy calculator = new Doy();
		System.out.println(calculator.getDayOfWeek(2,30,1));
		
		
	}
	
	
	
	//Find the difference in days between 2 dates
	int getDifferenceInDays(DoyDate date1, DoyDate date2){
		//TODO error checking parameters
		
		int yearDifference = date1.diffWithYear(date2);
		
		int daysDifference=getDaysLeftInYear(date1.getDay(), date1.getMonth(), date1.getYear());
		for(int i=0;i<yearDifference;i++){
			
		}
		return 0;
	}
	
	/**
	 * Numbers of days in a given year 
	 * @param year
	 * @return
	 */
	int getDaysInYear(int year) {
		if(isleapYear(year)){
			return 366; 
		}
		return 365;
	}
	
	/**
	 * TODO
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	int getDaysLeftInYear(int day,int month, int year){
		int result=getDaysInMonth(month, year)-day;
		for(int i=month+1;i<=12;i++){
			//sum up the number of days of the remaining months in the year 
			result=+getDaysInMonth(i, year);
		}
		return result;
	}
	
	/**
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	int getDaysInMonth(int month, int year){
		if(month==2){ //month of February
			if(isleapYear(year)) return 29;
			return 28;
		}
		else{
			for(int i=0;i<this.thirthy.length;i++){
				if (thirthy[i]==month){
					return 30;
				}
			}
			for(int i=0;i<this.thirthyOne.length;i++){
				if (thirthyOne[i]==month){
					return 31;
				}
			}
			return -1;
		}
	}
	
	/**
	 * Gets the day of the week given a known day and day of week in the same month.
	 * @param day
	 * @param givenDay
	 * @param givenDayOfWeek
	 * @return
	 */
	int getDayOfWeek(int day,int givenDay, int givenDayOfWeek) {
		int dayOfWeek=0; 
		if(verifyDayOfWeek(givenDayOfWeek)){
			if(givenDay<=day){
				dayOfWeek = ((day-givenDay)+givenDayOfWeek);
				if(dayOfWeek > 7){
					int temp = dayOfWeek%7;
					dayOfWeek=(temp==0)?7:temp;
				}
			}
			else{
				//get the 1st day of the month and the corresponding day of the week
				int temp=givenDay-1;
				int firstDayOfWeek = wrapToCorrectDay(givenDayOfWeek-temp);
				dayOfWeek=getDayOfWeek(day,1,firstDayOfWeek);
			}
		}
		
		return dayOfWeek;
	}
	
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	int wrapToCorrectDay(int value) {
		int temp=Math.abs(value),dayOfWeek=0;
		if(value<0){
			if(temp>7){
				dayOfWeek=7-(temp%7);
			}
			else{
				dayOfWeek=7-temp;
			}
		}
		else if(value>7){
			dayOfWeek=value%7;
		}
		return dayOfWeek;
		
		
	}
	boolean verifyDayOfWeek(int dayOfWeek){
		return ((dayOfWeek<=7) && (dayOfWeek>0));
	}
	
	
}

//A simplified custom date class.
class DoyDate{
	private int year,month,day,dayOfWeek;
	
	public DoyDate(int year,int month,int day, int dayOfWeek){
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	public boolean after(DoyDate otherDate){
		if(year>otherDate.year){
			return false;
		}else if(otherDate.year>year){
			return true;
		}else{
			//Same year, so compare months
			if(month>otherDate.month){
				return false;
			}else if(otherDate.month>month){
				return true;
			}else{
				//same month, so compare days
				if(day>otherDate.day){
					return false;
				}else if(otherDate.day>day){
					return true;
				}else{
					//Same year, month and day
					return false;
				}
				
			}
		
		}
	}
	
	void setYear(int year){
		this.year=year;
	}
	
	void setMonth(int month){
		this.month=month;
	}
	
	void setDay(int day){
		this.day=day;
	}
	
	int getYear(){
		return this.year;
	}
	
	int getMonth(){
		return this.month;
	}
	
	int getDay(){
		return this.day;
	}
	
	int diffWithYear(DoyDate date){
		int otherYear=date.getYear();
		
		return (otherYear>this.year)?otherYear-year:year-otherYear;
	}
	
	
}
