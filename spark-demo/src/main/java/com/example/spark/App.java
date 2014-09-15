package com.example.spark;

import static spark.Spark.*;

import spark.servlet.SparkApplication;

public class App implements SparkApplication {
    @Override
    public void init() {
        get("/", (req, res) -> "Hello World!");
    }
}
