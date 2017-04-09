package UMLparser;

import java.net.*;
import java.io.*;

public class CreateImage {
	public static void generatePNG(String grammar, String outPath) throws MalformedURLException {
		String webLink = null;
		try {
			webLink = "https://yuml.me/diagram/plain/class/" + URLEncoder.encode(grammar, "UTF-8") + ".png";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        URL url = new URL(webLink);
	}
}
