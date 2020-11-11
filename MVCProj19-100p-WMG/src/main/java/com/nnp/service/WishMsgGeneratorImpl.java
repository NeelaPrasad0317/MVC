package com.nnp.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishMsgGeneratorImpl implements IWishMsgGenerator{
	@Override
	public String getWmg() {
		LocalDateTime time=LocalDateTime.now();
		int hr=time.getHour()+1;
		if(hr<12) {
			return "GoodMorning ";
		}else if(hr<16)
			return "GoodAfternoon ";
		else if(hr<20)
			return "GoodEvening ";
		else
			return "GoodNight ";
	}

}
