package com.itaki.radyodinlenir.web.tools;

import org.springframework.stereotype.Component;

@Component
public class CleanUrlCreater {
	char[] characterGet = { 'ç', 'ı', 'ğ', 'ö', 'ş', 'ü', '!', '?', ' ', '*', '\'', '(', ')', ':', ';' };
	char[] characterSet = { 'c', 'i', 'g', 'o', 's', 'u', '-', '-', '-', '-', '-', '-', '-', '-', '-' };

	public String convert(String text) {
		String newText = text.toLowerCase();
		for (int i = 0; i < newText.length(); i++) {
			for (int k = 0; k < characterGet.length; k++) {
				if (newText.charAt(i) == characterGet[k]) {
					StringBuilder builder = new StringBuilder(newText);
					builder.setCharAt(i, characterSet[k]);
					newText = builder.toString();
				}
			}
		}
		return newText;
	}

}