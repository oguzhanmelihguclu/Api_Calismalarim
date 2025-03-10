package tests;

import baseUrl.RESTFULL_baseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P15_HerOkuAppQueryParams extends RESTFULL_baseUrl {

       /*

    https://restful-booker.herokuapp.com/booking endpointine
    gerekli Query parametrelerini yazarak
    “firstname” degeri “Eric” olan rezervasyon oldugunu test edecek
    bir GET request gonderdigimizde, donen response’un status code’unun
    200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin

 */

    @Test
    public void test(){

        //entpoint hazirlanir
        specRestFull.pathParam("pp1","booking").queryParam("firstname","Eric");

        // exp yok

        // response hazirlanir
        Response response = given().when().spec(specRestFull).get("/{pp1}");

     //   response.prettyPrint();

        // assertion
       response.then().assertThat().statusCode(200).body("size()", Matchers.greaterThan(0));
    }

}
