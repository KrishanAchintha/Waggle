package com.example.waggle.Models;

import com.example.waggle.Views.Viewfactory;

public class Models {
    private static Models model;
    private final Viewfactory viewfactory;

    public Models() {
        this.viewfactory =new Viewfactory();
    }

    public static synchronized Models getInstance(){
        if(model == null)
        {
            model = new Models();
        }
        return model;
    }

    public Viewfactory getViewManage(){
        return viewfactory;
    }
}
