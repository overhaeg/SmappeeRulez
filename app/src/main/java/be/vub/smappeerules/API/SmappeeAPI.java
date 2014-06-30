package be.vub.smappeerules.API;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 * Created by overhaeg on 30-06-14.
 */
public class SmappeeAPI {

    public void authenticate() throws IOException {


        URL url = new URL(Constants.AUTH_URL);
        String parameters = "grant_type=" + Constants.GRANT_TYPE + "&" +
                            "client_id" + Constants.CLIENT_ID + "&" +
                            "client_secret" + Constants.CLIENT_SECRET + "&" +
                            "username" + Constants.USERNAME + "&" +
                            "password" + Constants.PASSWORD;
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Content-Length", "" + Integer.toString(parameters.getBytes().length));

        connection.setDoOutput(true);


        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(parameters);
        wr.flush();
        wr.close();



    }

}
