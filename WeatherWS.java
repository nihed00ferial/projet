/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.weather;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 *
 * @author j
 */
@WebService()
 public class WeatherWS {

         private static final String API_KEY = "73d0f26c329f38d5cc441122d03e4544"; // استبدل بمفتاح API الخاص بك
         private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

         @WebMethod
         public String getWeather(String city) {
             try {
                 // بناء رابط API
                 String urlString = String.format(API_URL, city, API_KEY);
                 URL url = new URL(urlString);

                 // فتح اتصال HTTP
                 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                 conn.setRequestMethod("GET");

                 // قراءة الاستجابة
                 BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                 String inputLine;
                 StringBuilder response = new StringBuilder();

                 while ((inputLine = in.readLine()) != null) {
                     response.append(inputLine);
                 }
                 in.close();

                 // إرجاع الاستجابة كـ JSON
                 return response.toString();

             } catch (Exception e) {
                 return "Error: " + e.getMessage();
             }
         }
     }