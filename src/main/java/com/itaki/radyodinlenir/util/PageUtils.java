package com.itaki.radyodinlenir.util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

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
	
	public static String getCurentFullPath(HttpServletRequest request) throws URISyntaxException, MalformedURLException {
		URL url = new URL(request.getRequestURL().toString());
	    String host  = url.getHost();
	    String userInfo = url.getUserInfo();
	    String scheme = url.getProtocol();
	    int port = url.getPort();
	    String path = (String) request.getAttribute("javax.servlet.forward.request_uri");
	    String query = (String) request.getAttribute("javax.servlet.forward.query_string");	    
	    URI uri = new URI(scheme,userInfo,host,(port == 80 ? -1 : port),path,query,null);
	    return uri.toString();
	}
	
	public static String getHost(HttpServletRequest request) throws URISyntaxException, MalformedURLException {
		URL url = new URL(request.getRequestURL().toString());
	    String host  = url.getHost();
	    String userInfo = url.getUserInfo();
	    String scheme = url.getProtocol();
	    int port = url.getPort();    
	    URI uri = new URI(scheme,userInfo,host,(port == 80 ? -1 : port),null,null,null);
	    return uri.toString();
	}
}
