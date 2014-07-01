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
import java.util.List;

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
    public List<Location> getServiceLocations() throws IOException {

        List<Location> locations = new ArrayList<Location>();

        URL url = new URL(Constants.GET_URL);

        StringBuffer response = getData(url);

        JsonArray jsonArr = new JsonParser().parse(response.toString()).getAsJsonArray();

        for(int i = 0; i<jsonArr.size(); i++)
        {
            JsonObject obj = jsonArr.get(i).getAsJsonObject();
            String id = obj.get("serviceLocationId").getAsString();
            String name = obj.get("name").getAsString();
            Location location = new Location(id, name);
            locations.add(location);
        }

        return locations;

    }


    public void getServiceLocationInfo(Location location) throws IOException {

        String url_string = Constants.GET_URL + "/" +  location.getId() + "/info";
        URL url = new URL(url_string);

        StringBuffer response = getData(url);
        JsonObject jsonObj = new JsonParser().parse(response.toString()).getAsJsonObject();
        String timezone;
        if (jsonObj.has("timezone"))
            timezone = jsonObj.get("timezone").getAsString();
        else timezone = "";

        String lon = jsonObj.get("lon").getAsString();
        String lat = jsonObj.get("lat").getAsString();
        String electricityCost = jsonObj.get("electricityCost").getAsString();
        String electricityCurr = jsonObj.get("electricityCurrency").getAsString();

        JsonArray j_appliances = jsonObj.getAsJsonArray("appliances");
        List<Appliance> appliances = new ArrayList<Appliance>();

        for (int i = 0; i<j_appliances.size();i++)
        {
            JsonObject obj = j_appliances.get(i).getAsJsonObject();
            String id = obj.get("id").getAsString();
            String name = obj.get("name").getAsString();
            Appliance appliance = new Appliance(id, name);
            appliances.add(appliance);
        }

        location.updateLocation(timezone,lon,lat,electricityCost,electricityCurr, appliances);

    }
/*
    public JsonObject getConsumption(String id, String from, String to, String aggregation) throws IOException {

        String url_string = Constants.GET_URL + "/" +  id + "/consumption?"
                + "aggregation=" + aggregation + "&"
                + "from=" + from + "&"
                + "to=" + to;
        URL url = new URL(url_string);

        JsonObject jsonObj = getData(url);

        return jsonObj;

    }

    public JsonObject getEvents(String id, List<String> applianceIds, String from, String to, String maxNumber) throws IOException {

        String appIds_string = "";
        for(int i = 0; i < applianceIds.size(); i++)
        {
            id = applianceIds.get(i);
            appIds_string = appIds_string + "applianceId=" + id + "&";
        }
        String url_string = Constants.GET_URL + "/" + id + "/events"
                + appIds_string
                + "maxNumber=" + maxNumber + "&"
                + "from=" + from + "&"
                + "to=" + to;
        URL url = new URL(url_string);
        JsonObject jsonObj = getData(url);

        return jsonObj;

    }
    */

}
