package com.nnp.service;

import java.util.Calendar;

public class WishMessageGeneratorImpl implements WishMessageGenerator{

	@Override
	public String generateMessage() {
		var hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour<12) 
			return "GoodMorning...!";
		else if(hour<16)
			return "GoodAfternoon...!";
		else if(hour<20)
			return "GoodEvening...!";
		else
			return "GoodNight...!";
	}
	
}
