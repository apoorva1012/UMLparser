package UMLparser;

import java.net.*;
import java.io.*;

public class CreateImage {
	public static void generatePNG(String grammar, String outPath) throws MalformedURLException {
		String webLink = null;
		try {
			webLink = "https://yuml.me/diagram/plain/class/" + URLEncoder.encode(grammar, "UTF-8") + ".png";
			URL url = new URL(webLink);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException(
                        "Failed : HTTP error code : " + conn.getResponseCode());
            }
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
