package br.com.semaforo.util;

import java.net.*;

public class Utils {
	private static URL pathUrl;
	
	public static URL getResourceImage(String fileImage) {
		try {
			pathUrl = getPath("/br/com/semaforo/images/".concat(fileImage));
		} catch (URISyntaxException | MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		return pathUrl;
	}
	
	private static URL getPath(String pack) throws URISyntaxException, MalformedURLException {
		pathUrl = Utils.class.getResource(pack);
		return pathUrl;
	}
}