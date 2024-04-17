package com.example.waggle.Controllers;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    private DBInfo db;
    private String message;
    private String sid;
    private String url;

    public DBInfo getDb() {
        return db;
    }

    public String getMessage() {
        return message;
    }

    public String getSid() {
        return sid;
    }

    public String getUrl() { // new getter
        return url;
    }

    static class DBInfo {
         @SerializedName("connection_url")
        private String connection_url;
        private String password;
        private String username;

        public String getConnectionUrl() {
            return connection_url;
        }

        public String getPassword() {
            return password;
        }

        public String getUsername() {
            return username;
        }

    }
}
