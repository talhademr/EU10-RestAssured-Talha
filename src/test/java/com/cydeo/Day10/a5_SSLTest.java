package com.cydeo.Day10;

import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
public class a5_SSLTest {
    @Test
    public void test1(){
        given().
                relaxedHTTPSValidation(). //even if it doesnt have valid certificate I want to send request
                when().get("https://untrusted-root.badssl.com/")
                .prettyPrint();

    }
}
