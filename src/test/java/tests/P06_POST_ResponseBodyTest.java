package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P06_POST_ResponseBodyTest {
     /*

          https://jsonplaceholder.typicode.com/posts url’ine
          asagidaki body ile bir POST request gonderdigimizde
                {
                “title”:“API”,
                "body":"API ogrenmek ne guzel",
                 “userId”:10,
                }

        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body’sindeki,
           “title”’in “API” oldugunu
           “userId” degerinin 100’den kucuk oldugunu
           “body” nin “API” kelimesi icerdigini
        test edin.

  */


    @Test
    public void test06(){

        // end point hazirlanir ( req var )

        String url =" https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody =new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        // expected body hazirlanir


        // response hazirlanir
        Response response =given().when().contentType(ContentType.JSON)
                .body(reqBody.toString()).post(url);

        // assertion islemleri
        response.then().assertThat().statusCode(201)
                .contentType("application/json")
                .body("title", Matchers.equalTo("API"))
                .body("userId", Matchers.lessThan(100))
                .body("body", Matchers.containsString("API"));
    }

}
