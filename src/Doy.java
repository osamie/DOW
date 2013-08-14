//DAY OF THE WEEK

//30 days: september, april, june, november, 
//28 days (in common years): Febraury
//29 days (in leap years): February
import java.io.*;
import java.util.Date;

public class Doy{

	static boolean isleapYear(int year){
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

		/*
		//error check args
		if(args.length<reqArgsCount){
			System.out.println("Please enter a valid year value");
			System.exit(-1);
		}
		//initialize date components 
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int day = Integer.parseInt(args[2]);
		*/
		
		System.out.println(getDayOfWeek(2,30,1));
		/*while (entryInvalid){
			System.out.println("Please enter a year:");
			BufferedReader reader = new BufferedReader(new InputStreamreader(System.in()));
			int value=Integer.parseInt(reader.readLine()); 
			System.out.println(isleapYear(value));	
		}
		*/
		
	}
	
	/**
	 * Gets the day of the week given a known day and day of week in the same month.
	 * @param day
	 * @param givenDay
	 * @param givenDayOfWeek
	 * @return
	 */
	static int getDayOfWeek(int day,int givenDay, int givenDayOfWeek) {
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
	static int wrapToCorrectDay(int value) {
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
	static boolean verifyDayOfWeek(int dayOfWeek){
		return ((dayOfWeek<=7) && (dayOfWeek>0));
	}


}
