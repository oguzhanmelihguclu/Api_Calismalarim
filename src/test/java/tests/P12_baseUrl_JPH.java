package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P12_baseUrl_JPH extends JPH_baseUrl {

        /*

            https://jsonplaceholder.typicode.com/posts endpointine
             bir GET request gonderdigimizde
             donen response’un status code’unun 200 oldugunu ve
             Response’ta 100 kayit oldugunu test edin

   // testng
     */


    @Test
    public void test(){

        // endpoint hazirlama
        specJPH.pathParam("pp1","posts");

        // exp body verilmemis

        // Response hazirlama
        Response response = given().when().spec(specJPH).get("/{pp1}");

        // Assertion
        response.then().assertThat().statusCode(200).body("body", Matchers.hasSize(100));

    }

       /*
    2- https://jsonplaceholder.typicode.com/posts/44 endpointine
        bir GET request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “title” degerinin
        “optio dolor molestias sit” oldugunu test edin

     */


    @Test
    public void test02(){

        // entpoint hazirlama
        specJPH.pathParams("pp1","posts","pp2","44");

        // exp yok

        // response hazirlama
        Response response=given().when().spec(specJPH).get("/{pp1}/{pp2}");

        //assertion
        response.then().assertThat().statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));


    }

}
