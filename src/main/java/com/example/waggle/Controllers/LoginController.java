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


public class LoginController implements Initializable {

    public Button Login_btn;
    public Label error_lbl;
    public PasswordField Password;
    public TextField Username;
    public Button Clear_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Login_btn.setOnAction(event -> onLogin());
        // Clear_btn.setOnAction(event -> Clear());
    }

    /*
        private void onLogin() {
            String username = Username.getText();
            String password = Password.getText();

            if (username.isEmpty() || password.isEmpty()) {
                error_lbl.setText("Please fill in all fields !");
                return;
            } else if (!username.equals("admin") || !password.equals("admin")) {
                error_lbl.setText("Invalid username or password !");
                return;
            } else {

                Stage stage = (Stage) error_lbl.getScene().getWindow();
                Models.getInstance().getViewManage().closeStage(stage);
                Models.getInstance().getViewManage().clientWindow();
        }
        }

        private void Clear(){
            Username.clear();
            Password.clear();
            error_lbl.setText("");
        }



     */
    public void onLogin() {

        HttpClient httpClient = HttpClient.newHttpClient();
        String API_URL = "http://159.65.12.91/api/user/login";

        Map<Object, Object> data = Map.of(
                "username", Username.getText(),
                "password", Password.getText()
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}