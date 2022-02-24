package com.bridgelabz;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonApiTestBDD_Style {
    //    Behaviour Driven Development
    @Test
    public void getTest() {
        RestAssured.given()
                .when().get(" http://localhost:3000/posts")
                .then().assertThat().statusCode(200);
    }
    @Test
    public void getTest1() {
        Response response = RestAssured.get("http://localhost:3000/posts");

        System.out.println("Response code: " + response.getStatusCode());
        response.prettyPrint();

    }

    @Test
    public void postTest() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1 );
        jsonObject.put("title", "TitleValue");
        jsonObject.put("author", "QA");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toJSONString())
                .when()
                .post("http://localhost:3000/posts")
                .then()
                .statusCode(201);


    }
    //
//	    @Test
//	    public void postTest1() {
//
//	        JSONObject jsonObject = new JSONObject();
//	        jsonObject.put("id", 5);
//	        jsonObject.put("title", "Title value");
//	        jsonObject.put("author", "vishal");
//	        RestAssured.given()
//	                .header("Content-Type", "application/json")
//	                .body(jsonObject.toJSONString())
//	                .when()
//	                .post("http://localhost:3000/posts")
//	                .then()
//	                .statusCode(201);
//	    }
    @Test
    public void postTest2() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("title", "Title value");
        jsonObject.put("author", "vishal");
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toJSONString())
                .when()
                .post("http://localhost:3000/posts");


        response .statusCode();
        response.asString();
        response.prettyPrint();

    }

    @Test
    public void putTest() {

        JSONObject jsonObject = new JSONObject();
        // jsonObject.put("id", 1);
        jsonObject.put("title", "QAtest Engineer");
        jsonObject.put("author", "Vishal");
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toJSONString())
                .when()
                .put("http://localhost:3000/posts/1");


        response .statusCode();
        response.asString();
        response.prettyPrint();
    }
    @Test
    public void deleteTest() {

        JSONObject jsonObject = new JSONObject();
//	        jsonObject.put("id", 15);
//	        jsonObject.put("title", "QA test");
//	        jsonObject.put("author", "Vishal");
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toJSONString())
                .when()
                .delete("http://localhost:3000/posts/1")
                .then()
                .statusCode(200);
    }

}
