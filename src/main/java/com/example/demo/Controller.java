package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GETDATA;

    @FXML
    private TextField CITY;

    @FXML
    void initialize() {
   GETDATA.setOnAction(event -> {
       String getUserCity = CITY.getText().trim();
       String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + getUserCity +"&appid=1cabf1029c1a4b949d8196f3140b433b&units=metric");

       if (!output.isEmpty()) {
           JSONObject obj = new JSONObject(output);
           textTemperature.setText("Temperature: " + obj.getJSONObject("main").getDouble("temp"));
           textfeel.setText("Real feel: " + obj.getJSONObject("main").getDouble("feels_like"));
           textMaximum.setText("Maximum: " + obj.getJSONObject("main").getDouble("temp_max"));
           textMinimum.setText("Minimum: " + obj.getJSONObject("main").getDouble("temp_min"));
           textPressure.setText("Pressure: " + obj.getJSONObject("main").getDouble("pressure"));
       }
   });
    }
    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();
      try{
        URL url = new URL(urlAdress);
        URLConnection urlConn = url.openConnection();

          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
          String line;

          while((line = bufferedReader.readLine()) != null) {
              content.append(line + "\n");
              }
             bufferedReader.close();
      } catch(Exception e) {
          System.out.println("City not found");
      }
      return content.toString();
    }
}