package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class P07_bodyTekrarindanKurtulma {

      /*

     https://restful-booker.herokuapp.com/booking/10 url’ine
     bir GET request gonderdigimizde donen Response’un,
         status code’unun 200,
         ve content type’inin application-json,
         ve response body’sindeki
            “firstname”in, “Susan”,
         ve “lastname”in, “Brown”,
         ve “totalprice”in, 267,
         ve “depositpaid”in, false,
         ve “additionalneeds”in, “Breakfast”
    oldugunu test edin

  */

    @Test
    public void test07(){

        // end point hazirlanir ( req yok cünkü get)

        String url ="https://restful-booker.herokuapp.com/booking/10";

        // expected body hazirlanir

        // responce hazirlanir
        Response response =given().when().get(url);

        // assertion yapilir

        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                .body("firstname",equalTo("Susan"),"lastname",equalTo("Brown")
                       , "totalprice",equalTo(267),"depositpaid",equalTo(false));

    }
}
