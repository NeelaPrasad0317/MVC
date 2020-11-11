package com.nnp.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class LocaleInfoServiceImpl implements ILocaleInfoService {

	@Override
	public Set<String> fetchAllCountriesList() {
		Set<String> contries=new TreeSet<String>();
		Locale[] locales=Locale.getAvailableLocales();
		for(Locale l:locales) {
			if(!l.getDisplayCountry().isEmpty())
				contries.add(l.getDisplayCountry());
		}
		return contries;
	}

}
