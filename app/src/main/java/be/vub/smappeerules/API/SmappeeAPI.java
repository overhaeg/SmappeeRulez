package be.vub.smappeerules.API;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by overhaeg on 30-06-14.
 */
public class SmappeeAPI {

    String access_token;
    String refresh_token;
    String lastUpdate = "0";
    Map<String,String> appliances;
    List<String> locations;

    public SmappeeAPI() throws IOException {

        locations = new ArrayList<String>();
        appliances = new HashMap<String, String>();
        URL url = new URL(Constants.AUTH_URL);
        String parameters = "grant_type=" + Constants.GRANT_PSW + "&" +
                "client_id=" + Constants.CLIENT_ID + "&" +
                "client_secret=" + Constants.CLIENT_SECRET + "&" +
                "username=" + Constants.USERNAME + "&" +
                "password=" + Constants.PASSWORD;
        System.out.println(parameters);
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

    private StringBuffer getData(URL url) throws IOException
    {
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        String access = "Bearer " + access_token;
        connection.setRequestProperty("Authorization", access);
        System.out.println(access);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());

        return response;



    }

    private HttpsURLConnection postConnection(URL url, String parameters) throws IOException
    {

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Host", "app1pub.smappee.net");
        connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        connection.setRequestProperty("charset", "UTF-8");
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
    //Returns a list with Location objects for each location.
    public void getServiceLocations() throws IOException {

        URL url = new URL(Constants.GET_URL);

        StringBuffer response = getData(url);

        JsonArray jsonArr = new JsonParser().parse(response.toString()).getAsJsonArray();

        for(int i = 0; i<jsonArr.size(); i++)
        {
            JsonObject obj = jsonArr.get(i).getAsJsonObject();
            String id = obj.get("serviceLocationId").getAsString();
            locations.add(id);
        }


    }


    public void getServiceLocationInfo() throws IOException {

        String url_string = Constants.GET_URL + "/" +  locations.get(0) + "/info";
        URL url = new URL(url_string);

        StringBuffer response = getData(url);
        JsonObject jsonObj = new JsonParser().parse(response.toString()).getAsJsonObject();

        JsonArray j_appliances = jsonObj.getAsJsonArray("appliances");

        for (int i = 0; i<j_appliances.size();i++)
        {
            JsonObject obj = j_appliances.get(i).getAsJsonObject();
            String id = obj.get("id").getAsString();
            String name = obj.get("name").getAsString();
            appliances.put(name,id);
        }

    }


/*
    public List<Consumption> getConsumption(Location loc, String from, String to, String aggregation) throws IOException {

        String url_string = Constants.GET_URL + "/" +  loc.getId() + "/consumption?"
                + "aggregation=" + aggregation + "&"
                + "from=" + from + "&"
                + "to=" + to;
        URL url = new URL(url_string);

        StringBuffer response = getData(url);
        JsonObject jsonObj = new JsonParser().parse(response.toString()).getAsJsonObject();
        JsonArray j_consumptions = jsonObj.getAsJsonArray("consumptions");

        List<Consumption> consumptions = new ArrayList<Consumption>();

        for (int i = 0; i<j_consumptions.size();i++)
        {
            JsonObject obj = j_consumptions.get(i).getAsJsonObject();
            String timestamp = obj.get("timestamp").getAsString();
            String consumption = obj.get("consumption").getAsString();
            String solar = obj.get("solar").getAsString();
            String alwaysOn = obj.get("alwaysOn").getAsString();
            Consumption con = new Consumption(timestamp, consumption, solar, alwaysOn);
            consumptions.add(con);
        }

        return consumptions;

    }
*/
    public List<String> getEvents(String name) throws IOException {
        String appId = appliances.get(name);
        String from = "0";
        String to =  Long.toString(new Date().getTime());


        String url_string = Constants.GET_URL + "/" + locations.get(0) + "/events?"
                + "appliance=" + appId + "&"
                + "maxNumber=" + "1" + "&"
                + "from=" + from + "&"
                + "to=" + to;
        URL url = new URL(url_string);
        StringBuffer response = getData(url);

        JsonArray arr = new JsonParser().parse(response.toString()).getAsJsonArray();
        JsonObject val = arr.get(0).getAsJsonObject();


        String activePower = val.get("activePower").getAsString();
        String timestamp = val.get("timestamp").getAsString();
        List<String> list = new ArrayList<String>();
        list.add(activePower);
        list.add(timestamp);

        return list;

    }

    public List<String> getApplianceNames() {

        return new ArrayList(appliances.keySet());

    }





}
