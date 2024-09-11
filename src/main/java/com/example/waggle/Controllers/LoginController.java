package com.example.waggle.Controllers;

import com.example.waggle.Models.Models;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.HLineTo;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.HashMap;


public class LoginController implements Initializable {

    public Button Login_btn;
    public Label error_lbl;
    public PasswordField Password;
    public TextField Username;
    public Button Clear_btn;

    public static String extractedUsername;
    public static String extractedPassword;
    public static String ssid;
    public static String url;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Login_btn.setOnAction(event -> onLogin());
        Clear_btn.setOnAction(event -> Clear());
    }

    private void onLogin(){

            String username = Username.getText();
            String password = Password.getText();

            if (username.isEmpty() || password.isEmpty()) {
                error_lbl.setText("Please fill in all fields !");
                return;
            } else if (!username.equals("admin") || !password.equals("admin")) {
                error_lbl.setText("Invalid username or password !");
                return;
            } else {

                url = "jdbc:mysql://sql6.freesqldatabase.com:3306/sql6702245";
                extractedUsername = "sql6702245";
                extractedPassword ="5EjAx8cGNr";

                DataBaseConnector.getConnection();

                Stage stage = (Stage) error_lbl.getScene().getWindow();
                Models.getInstance().getViewManage().closeStage(stage);
                Models.getInstance().getViewManage().clientWindow();
            }

    }


    /*
    public void onLogin() {

        HttpClient httpClient = HttpClient.newHttpClient();
        String API_URL = "http://159.65.12.91/api/user/login";

        // Prepare form data
        String username = Username.getText();
        String password = Password.getText();
        String formData = "username=" + username + "&password=" + password;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(formData))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // Parse JSON response
            Gson gson = new Gson();
            ApiResponse responseData = gson.fromJson(response.body(), ApiResponse.class);

            if(response.statusCode() == 200){
                // Extract values
                extractedUsername = responseData.getDb().getUsername();
                extractedPassword = responseData.getDb().getPassword();
                ssid = responseData.getSid();
                url = responseData.getDb().getConnectionUrl();

                DataBaseConnector.getConnection();

                // Store values
                Stage stage = (Stage) error_lbl.getScene().getWindow();
                Models.getInstance().getViewManage().closeStage(stage);
                Models.getInstance().getViewManage().clientWindow();

            }else{
                error_lbl.setText("Login Failed");
                Username.clear();
                Password.clear();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
*/
    private void Clear(){
        Username.clear();
        Password.clear();
        error_lbl.setText("");
    }



}