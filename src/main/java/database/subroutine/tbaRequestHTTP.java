package database.subroutine;

import sun.net.www.http.HttpClient;

import javax.ws.rs.core.HttpHeaders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class tbaRequestHTTP {

    String autKey = "IFNmxeN26EKG5jzgrk3rdvmwHWVtS1HwZQQMy2FXJOV6MdsiVcG6smti6EetgaOD";

    public static String getTBAMatchData() throws IOException {

        String url = "www.thebluealliance.com/api/v3/event/2019onnob/matches";

        URL obj = new URL("www.thebluealliance.com/api/v3/event/2019onnob/matches");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("X-TBA-Auth-Key", "IFNmxeN26EKG5jzgrk3rdvmwHWVtS1HwZQQMy2FXJOV6MdsiVcG6smti6EetgaOD");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        return  response.toString();
    }

}
