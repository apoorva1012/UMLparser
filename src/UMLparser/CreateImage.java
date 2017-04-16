package UMLparser;

import java.net.*;
import java.io.*;

public class CreateImage {

    public static Boolean generatePNG(String grammar, String outPath) {

        try {

            String webLink = "https://yuml.me/diagram/plain/class/" + URLEncoder.encode(grammar, "UTF-8") + ".png";
            URL url = new URL(webLink);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException(
                        "Failed : HTTP error code : " + conn.getResponseCode());
            }
            OutputStream outputStream = new FileOutputStream(new File(outPath));
            int read = 0;
            byte[] bytes = new byte[1024];
           
            outputStream.close();
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
