package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P04_PUT_ResponseInformationAssert {

     /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine
        asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
        RequestBody verilmiş
        {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
        }
        donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK



  */

    @Test
    public void test04(){

        // 1-end point hazirlanir ( request body var !!)

        String url =" https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody=new JSONObject();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        // 2-expected body hazirlanir

        // 3-response hazirlanir

        Response response = given().when().contentType(ContentType.JSON).body(reqBody.toString()).put(url);
        // content type'ı json olan body'sinde şu olan put sorgusunu gönder ve dönen cevabı response'a kaydet!!!


        // assertion yapilir

        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");


    }
}
