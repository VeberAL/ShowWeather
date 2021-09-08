package com.example.demo;

import java.net.URL;
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
        assert GETDATA != null : "fx:id=\"GETDATA\" was not injected: check your FXML file 'Untitled'.";
        assert CITY != null : "fx:id=\"CITY\" was not injected: check your FXML file 'Untitled'.";

    }
}