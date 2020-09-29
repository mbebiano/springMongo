package br.com.ntendencia.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	
	// metodo decodifica a requisição vinda da URL. Ex.: " " = %20 
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
