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
	
	
	//Given a MMYYYY, finds the last day of the month
	
	//Given a DOW & DDMMYYYY, finds the DOW of the 1st day of the next month 
	
	//Given a DOW & DDMMYYYY, finds the DOW of the 1st day of the next year
	
	
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

