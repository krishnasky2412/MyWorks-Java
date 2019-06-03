package com.sky.di;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

@SuppressWarnings("deprecation")
public class DateCompare {

    
	// Function to handle all date formats
	
	@SuppressWarnings("deprecation")
	public String dt_compare(String col_name, String src_format, String tgt_format, String src_date, String tgt_date, String region) throws ParseException
    {
						
		Date s_date =new SimpleDateFormat(src_format).parse(src_date);
//		Date t_date =new SimpleDateFormat(tgt_format).parse(tgt_date);
				
		String[] reg = {"GB","IR"};
		Set<String> names = new HashSet<String>(Arrays.asList(reg));			

//		System.out.println("Original Date: "+ src_date);
		LocalDateTime localDate = s_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();			
//		LocalDateTime t_localDate = t_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		int year  = localDate.getYear();
    	int month = localDate.getMonthValue();
    	int day   = localDate.getDayOfMonth();
    	int hrs = 0;
    	
//    	For region split (which is not required now)
//    	if(names.contains(region))		
//    		hrs = localDate.getHour();		
//    	else
//    		hrs = localDate.getHour();
    	
//        System.out.println(TimeZone.getTimeZone(region).inDaylightTime(s_date));
    	
    	if(TimeZone.getTimeZone(region).inDaylightTime(s_date))
    	{
    		if(names.contains(region))    		
    			hrs = localDate.getHour()-1;    		
    		else
    			hrs = localDate.getHour()-2;
    	}
    		
    	else
    		hrs = localDate.getHour();
    	    	
    	int min = localDate.getMinute();
    	int sec = localDate.getSecond();
        int nsec = localDate.getNano()/1000000;
        
        Calendar c = Calendar.getInstance();
//      c.set(year, month-1, day);
        
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, day);    
        c.set(Calendar.HOUR, hrs);
        
        if(min <= 0 && localDate.getMinute() <= 0)
        	c.set(Calendar.MINUTE, 0);
        else
        	c.set(Calendar.MINUTE, min);
        
        if(sec <= 0)        
        	c.set(Calendar.SECOND, 0);        
        else        	
        	c.set(Calendar.SECOND, sec);
        
        if(nsec == 0)
        	c.set(Calendar.MILLISECOND, 0);
        else
        	c.set(Calendar.MILLISECOND, nsec);		 					

//      System.out.println("-----------------------------");
//        
//      System.out.println("Year: "+year);
//		System.out.println("Month: "+month);
//    	System.out.println("Day: "+day);
//    	System.out.println("Hours: "+hrs);
//    	System.out.println("Minutes: "+min);
//    	System.out.println("Seconds: "+sec);
//    	System.out.println("Nano Seconds: "+nsec);    	
//		System.out.println(c.get(c.SECOND));
//    		
//    	System.out.println("-----------------------------");
//    	
    	Date new_dt = c.getTime();    	    
		    	
    	SimpleDateFormat src_sdf2 = new SimpleDateFormat(tgt_format);
    	src_sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
		String new_date = src_sdf2.format(new_dt); 
				
		try
		{
			ISO8601DateFormat df = new ISO8601DateFormat();
			Date d = df.parse(tgt_date);
		}
		catch(Exception e)
		{
//			System.out.println("Not in ISO 8601 UTC format");
//			System.out.println("Formatted Date: "+ new_date);
			return (new_date);
		}
		
//		System.out.println("Formatted Date: "+ new_date);		
		return (new_date);
		
    }

}