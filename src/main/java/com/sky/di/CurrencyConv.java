package com.sky.di;

import java.text.DecimalFormat;

public class CurrencyConv {

	
	public String curr_convert(String curr_col, String currency) 
	{
		
		if(currency.trim().isEmpty() == false)
		{
			currency = currency.replace(",", "");
			DecimalFormat df = new DecimalFormat("0.00");				
			double out_currency = Double.parseDouble(currency);
			Math.round(out_currency);
			
			return df.format(out_currency).toString();
		}
		else
		{
			System.out.println("Currency value is NULL");
			return "0";
		}
	}
}
