package com.cydeo.Day5;

import com.cydeo.utilities.DBUtils;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class a6_SpartanAPIvsDB extends SpartanTestBase {

    @DisplayName("GET one spartan from api and database")
    @Test
    public void testDB1() {
        //get id,name,gender phone  from database
        //get same information from api
        //compare

        //1. get id,name,gender phone  from database
        String query = "select spartan_id,name,gender,phone from spartans\n" +
                "where spartan_id = 15";

        //save data inside the map
        Map<String, Object> dbMap = DBUtils.getRowMap(query);
        System.out.println(dbMap);

        //2.get info from api
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when()
                .get("/api/spartans/{id}")
                .then()
                .statusCode(200)
                .and().contentType("application/json")
                .extract().response();

        //Deserialization here JSon to Java  with Jackson objectMapper
        Map<String, Object> apiMap = response.as(Map.class);
        System.out.println(apiMap);



    }

}
