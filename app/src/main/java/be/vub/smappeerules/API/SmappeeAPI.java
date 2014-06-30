package be.vub.smappeerules.API;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 * Created by overhaeg on 30-06-14.
 */
public class SmappeeAPI {

    String access_token;
    String refresh_token;

    public SmappeeAPI() throws IOException {


        URL url = new URL(Constants.AUTH_URL);
        String parameters = "grant_type=" + Constants.GRANT_PSW + "&" +
                            "client_id" + Constants.CLIENT_ID + "&" +
                            "client_secret" + Constants.CLIENT_SECRET + "&" +
                            "username" + Constants.USERNAME + "&" +
                            "password" + Constants.PASSWORD;
        HttpsURLConnection connection = postConnection(url, parameters);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JsonObject jsonObj = new JsonParser().parse(response.toString()).getAsJsonObject();
        JsonElement acc_tok = jsonObj.get("access_token");
        JsonElement ref_tok = jsonObj.get("refresh_token");

        access_token = acc_tok.getAsString();
        refresh_token = ref_tok.getAsString();

    }

    private JsonObject getData(URL url) throws IOException
    {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.setRequestProperty("Authorization", access_token);


        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JsonObject jsonObj = new JsonParser().parse(response.toString()).getAsJsonObject();

        return jsonObj;
    }

    private HttpsURLConnection postConnection(URL url, String parameters) throws IOException
    {

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

        return connection;

    }


    private void refreshToken() throws IOException {

        URL url = new URL(Constants.AUTH_URL);
        String parameters = "grant_type=" + Constants.GRANT_RTK + "&" +
                            "refresh_tokens" + refresh_token + "&" +
                            "client_id" + Constants.CLIENT_ID + "&" +
                            "client_secret" + Constants.CLIENT_SECRET;

        HttpsURLConnection connection = postConnection(url, parameters);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JsonObject jsonObj = new JsonParser().parse(response.toString()).getAsJsonObject();
        JsonElement acc_tok = jsonObj.get("access_token");
        JsonElement ref_tok = jsonObj.get("refresh_token");

        access_token = acc_tok.getAsString();
        refresh_token = ref_tok.getAsString();

    }

    public JsonObject getServiceLocations() throws IOException {

        URL url = new URL(Constants.GET_URL);

        JsonObject jsonObj = getData(url);

        return jsonObj;

    }


    public JsonObject getServiceLocationInfo(String id) throws IOException {

        String url_string = Constants.GET_URL + "/" +  id + "/info";
        URL url = new URL(url_string);

        JsonObject jsonObj = getData(url);

        return jsonObj;
    }

    public JsonObject getConsumption(String id, String from, String to, String aggregation) throws IOException {

        String url_string = Constants.GET_URL + "/" +  id + "/consumption?"
                                              + "aggregation=" + aggregation + "&"
                                              + "from=" + from + "&"
                                              + "to=" + to;
        URL url = new URL(url_string);

        JsonObject jsonObj = getData(url);

        return jsonObj;

    }

   // public JsonObject getEvents(String id, List<String> applianceIds, String from, String to, String maxNumber) {

  //     String url_string = Constants.getURL + "/" + id + "/events"
//                                            +
   // }

//
}
