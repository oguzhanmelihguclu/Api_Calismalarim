package tests;

import baseUrl.RESTFULL_baseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P13_restfullBaseUrl extends RESTFULL_baseUrl {

         /*

       https://restful-booker.herokuapp.com/booking endpointine
       bir GET request gonderdigimizde donen response’un
       status code’unun 200 oldugunu ve
       Response’ta 12 bookingid'sine sahip booking oldugunu test edin

  */


    @Test
    public void test(){

        // entpoint hazirlanir
        specRestFull.pathParam("pp1","booking");

        // exp yok

        // response hazirlanir
        Response response =given().spec(specRestFull).when().get("/{pp1}");

      //  response.prettyPrint();

        // assertion
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(12));
    }


}
