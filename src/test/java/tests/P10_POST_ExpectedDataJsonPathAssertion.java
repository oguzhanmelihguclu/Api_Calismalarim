package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class P10_POST_ExpectedDataJsonPathAssertion {
        /*

https://restful-booker.herokuapp.com/booking url’ine
asagidaki body’ye sahip bir POST request gonderdigimizde

Request body
      {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }

donen response’un id haric asagidaki gibi oldugunu test edin.

Response Body - Expected Data
 {
    “bookingid”: 24,
    “booking”: {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        additionalneeds": "wi-fi"
    }
}

 */


    @Test
    public void test10(){

        // enpoint hazırlanır ( req var)

        String url ="https://restful-booker.herokuapp.com/booking";

        JSONObject innerReqBody =new JSONObject();
        innerReqBody.put("checkin","2021-06-01");
        innerReqBody.put("checkout","2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerReqBody);
        reqBody.put("additionalneeds","wi-fi");

        // exp body hazirlanir
        JSONObject expBody=new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",reqBody);

        // Response olusturulur
        Response response =given().when().contentType(ContentType.JSON).body(reqBody.toString()).post(url);

        response.prettyPrint();

        // assertion islemi
        JsonPath resJP=response.jsonPath();


        assertEquals(expBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin")
                ,resJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout")
                ,resJP.get("booking.bookingdates.checkout"));



        // NOT : EXP BODY BİR JSONOBJECT'TİR İÇERİSİNE GİREBİLMEK İÇİN GETJSONOBJECT KULLANILIR
        // NOT : RESJP İSE JSONPATH'DİR DİREKT İÇİNE ULASIM SAGLANABİLİR.

    }





}
