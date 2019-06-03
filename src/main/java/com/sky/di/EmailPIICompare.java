package com.sky.di;
import java.text.ParseException;

public class EmailPIICompare {
	 	
	public boolean email_pii_compare(String email_col, String pii_1, String pii_2) throws ParseException
	{
		String src_pii, tgt_pii, calc_pii;					
		
		if(pii_1.trim().isEmpty() == false && pii_2.trim().isEmpty() == false && pii_1.indexOf("@") > 1 && pii_2.indexOf("@") > 1)
		{
			src_pii = pii_1.substring(0, pii_1.indexOf("@"));
			tgt_pii = pii_2.substring(0, pii_2.indexOf("@"));
			calc_pii = "";
			
			System.out.println(src_pii);
			
			for(int i = 0;i<src_pii.length();i++)
			{
				calc_pii = calc_pii + "*";
			}
					
			if(src_pii.length() == tgt_pii.length())
			{
				if(tgt_pii.equals(calc_pii))
					return true;
				else
					System.out.println("Values are not obfuscated properly!");
					return false;
			}
			else
			{
				System.out.println("Not Matching");
				return false;
			}
		}
		else
		{
			System.out.println("NULL/improper value in Source (or) Target!");
			return false;
		}
	}
}