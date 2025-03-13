package br.com.semaforo.util;

import java.net.URL;

public class Utils {
	
	private Utils() {}
	
	public static URL getResourceImage(String fileImage) {
		
		return Utils.class.getResource(String.format("/br/com/semaforo/images/%s", fileImage));
		
	}
	
}