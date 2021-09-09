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
       System.out.println("Ok");
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