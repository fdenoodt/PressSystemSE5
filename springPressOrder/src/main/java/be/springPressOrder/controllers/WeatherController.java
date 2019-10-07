package be.springPressOrder.controllers;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class WeatherController {

    //@RequestMapping(path = "/current?lat=35&lon=139", produces = "application/json")
    //@CrossOrigin (origins="*")
    String getWeather() {

        try {
            String httpsURL = "https://fcc-weather-api.glitch.me/api/current?lat=35&lon=139";
            URL myUrl = null;
            myUrl = new URL(httpsURL);
            HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "weather";
    }
}
