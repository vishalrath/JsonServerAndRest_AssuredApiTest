package com.bridgelabz;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class FindInfoJsonApiTesting {

    @Test
    public void gettestid() {
        Response response = RestAssured.get("http://localhost:3000/posts");
        System.out.println("Response code:" + response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        System.out.println("id :" + jsonPath.get("id"));

    }
    @Test
    public void gettestTitle() {
        Response response = RestAssured.get("http://localhost:3000/posts");
        System.out.println("Response code:" + response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        System.out.println("title :" + jsonPath.get("title"));

    }
    @Test
    public void gettestAuthor() {
        Response response = RestAssured.get("http://localhost:3000/posts");
        System.out.println("Response code:" + response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        System.out.println("author :" + jsonPath.get("author"));

    }
}
