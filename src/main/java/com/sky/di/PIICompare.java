package com.sky.di;
import java.text.ParseException;

public class PIICompare {
 	
	public boolean pii_compare(String pii_col, String pii_1, String pii_2) throws ParseException
	{
		String src_pii, tgt_pii, calc_pii;
		src_pii = pii_1;
		tgt_pii = pii_2;
		calc_pii = "";
		
		if(pii_1.trim().isEmpty() == false && pii_2.trim().isEmpty() == false)
		{
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
			System.out.println("NULL value in Source (or) Target!");
			return false;
		}
	}
}