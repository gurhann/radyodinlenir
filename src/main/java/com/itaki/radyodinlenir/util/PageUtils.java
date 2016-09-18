package com.itaki.radyodinlenir.util;

public class PageUtils {
	
	private PageUtils() {
		
	}
	
	public static int getPageCount(int totalCount, int pageSize) {
		return (int) Math.ceil((double) totalCount / pageSize);
	}
	
	public static String convertCleanUrl(String text) {
		 char[] characterGet = { 'ç', 'ı', 'ğ', 'ö', 'ş', 'ü', '!', '?', ' ', '*', '\'', '(', ')', ':', ';' };
		 char[] characterSet = { 'c', 'i', 'g', 'o', 's', 'u', '-', '-', '-', '-', '-', '-', '-', '-', '-' };
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
