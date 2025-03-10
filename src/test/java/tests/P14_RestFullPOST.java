package tests;

import baseUrl.RESTFULL_baseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P14_RestFullPOST extends RESTFULL_baseUrl {
         /*
            https://restful-booker.herokuapp.com/booking endpointine
            asagidaki body’ye sahip bir POST request gonderdigimizde donen response’un
            status code’unun 200 oldugunu ve “firstname” degerinin “Murat” oldugunu test edin
{
     "firstname" : “Murat”,
     “lastname” : “Yiğit”,
     “totalprice” : 500,
     “depositpaid” : false,
     “bookingdates” : {
              "checkin": "2021-06-01",
              "checkout" : “2021-06-10”
                       },
     “additionalneeds” : “wi-fi”
  }
     */

    @Test
    public void test(){

        // entpoint hazirlanir ( req var)
        specRestFull.pathParam("pp1","booking");

        JSONObject innerReqBody=new JSONObject();
        innerReqBody.put("checkin","2021-06-01");
        innerReqBody.put("checkout","2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Murat");
        reqBody.put("lastname","Yiğit");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("additionalneeds","wi-fi");
        reqBody.put("bookingdates",innerReqBody);

        // exp yok

        // response hazirlanir

        Response response=given().contentType(ContentType.JSON)
                .spec(specRestFull).when()
                .body(reqBody.toString()).post("/{pp1}");

        response.prettyPrint();

        // assertion
        response.then().assertThat().statusCode(200).body("booking.firstname", Matchers.equalTo("Murat"));


    }

}
