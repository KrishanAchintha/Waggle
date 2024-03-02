package com.example.waggle;

import com.example.waggle.Models.Models;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

        //this is a comment

    @Override
    public void start(Stage stage)  {
        Models.getInstance().getViewManage().showLogin();
    }
}
//sddfsfd
