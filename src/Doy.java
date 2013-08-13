//DAY OF THE WEEK

//30 days: september, april, june, november, 
//28 days (in common years): Febraury
//29 days (in leap years): February
import java.io.*;

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

		//error check args
		if(args.length<reqArgsCount){
			System.out.println("Please enter a valid year value");
			System.exit(-1);
		}
		//initialize date components 
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int day = Integer.parseInt(args[2]);
		
		
		System.out.println(getDayOfWeek(year,month,day));
		/**while (entryInvalid){
			System.out.println("Please enter a year:");
			BufferedReader reader = new BufferedReader(new InputStreamreader(System.in()));
			int value=Integer.parseInt(reader.readLine()); 
			System.out.println(isleapYear(value));	
		}
		**/
		
	}

	static int getDayOfWeek(int year, int month, int day) {
		//30 days: september, april, june, november, 
		//28 days (in common years): Febraury
		//29 days (in leap years): February
		return 0;
	}


}
