package utilities;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class CalenderDDMMYYY {
	
	public String localCurrentMonth() {

		int monthNumber = YearMonth.now().getMonthValue();
        String monthName = Month.of(monthNumber).name();
        
        monthName = monthName.toLowerCase();

        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1);
 
        return monthName;
	}
	public String localCurrentYear() {
		String currentYear = Integer.toString(YearMonth.now().getYear());
		return currentYear;
	}
	
	public String formattedMonth() {
		return this.localCurrentMonth().substring(1, 4);
	}
	
	public String localHighlightedDayDateFormat() {
		
		LocalDate currentDate = LocalDate.now();

        // Format the date as "Fri, 09 Feb"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM", Locale.ENGLISH);
        String formattedDate = currentDate.format(formatter);

//        // Get the day of the week (e.g., "Fri")
//        String dayOfWeek = currentDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

        // Print the result
//        String dayDateFormat = dayOfWeek + ", " + formattedDate;
//        System.out.println(dayOfWeek + ", " + formattedDate);
        System.out.println(formattedDate);
        return formattedDate;
	}
	
	public ArrayList<String> localWeekDates() {
		
		ArrayList<String> myDates = new ArrayList<String>();
		LocalDate currentDate = LocalDate.now();
        int dayOfWeek = currentDate.getDayOfWeek().getValue();
        LocalDate sundayOfCurrentWeek = currentDate.minusDays((dayOfWeek)%7);
        
        for(int i=0;i<7;i++) {
        	LocalDate currentDateInWeek = sundayOfCurrentWeek.plusDays(i);
        	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM");
         String formattedDate = currentDateInWeek.format(formatter);
//         System.out.println(formattedDate);
         myDates.add(formattedDate);
        }
        
        return myDates;
	}
	
	public String date15DaysBefore() {
		
		LocalDate today = LocalDate.now();
		
        LocalDate dateBefore15Days = today.minusDays(15);
        DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("E, dd MMM", Locale.ENGLISH);
        String formatteddDate = dateBefore15Days.format(formatterr);
        System.out.println("Date 15 days before today: " + formatteddDate);
		
		return formatteddDate;
	}
	
}
