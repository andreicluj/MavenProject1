/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrei.mavenproject1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class NetClientGet {

    // http://localhost:8080/RESTfulExample/json/product/get
    public static void main(String[] args) {

        try {

            //URL url = new URL("http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Locators/ESRI_Geocode_USA/GeocodeServer/findAddressCandidates?Address=5536+LINDLEY+AVE+APT+102&City=Los+Angeles&State=CA&Zip=&outFields=&outSR=&f=json");
            String baseURL = "http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Locators/ESRI_Geocode_USA/GeocodeServer/findAddressCandidates?Address=";
            String address = "5536+LINDLEY+AVE+APT+102";
            String city = "Los+Angeles";

            String state = "CA";
            String sufix = "&f=json";
            String strUrl = String.format("%s?Address=%s&City=%s&State=%s&f=pjson", new String[]{baseURL, address, city, state});

            //baseURL  + address + "&City=" + city + "&State=" + state +sufix
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            
            
            printCoordinates(br);
            
            /*String output;

            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }*/

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static void printCoordinates(BufferedReader br) {
        
        System.out.println("-------------COORDINATES-------------");
        JsonReader rdr = Json.createReader(br);
        JsonObject obj = rdr.readObject();
        JsonArray results = obj.getJsonArray("candidates");
        for (JsonObject result : results.getValuesAs(JsonObject.class)) {
            System.out.print(result.getJsonObject("location").getString("x"));
            System.out.print(": ");
            System.out.println(result.getString("message", ""));
            System.out.println("-----------");
        }
    }

}
