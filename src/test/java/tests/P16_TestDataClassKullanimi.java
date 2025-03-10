package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import testDatas.JPHDatas;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class P16_TestDataClassKullanimi extends JPH_baseUrl {
       /*

     https://jsonplaceholder.typicode.com/posts/22 url’ine bir
    GET request yolladigimizda donen response’in
    status kodunun 200 ve
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
      Response body : (expected data)
    {
        “userId”: 3,
        “id”: 22,
        “title”: “dolor sint quo a velit explicabo quia nam”,
        “body”: “eos qui et ipsum ipsam suscipit aut\nsed omnis non odio
        \nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse”
}
 */

    @Test
    public void test01(){

        specJPH.pathParams("pp1","posts","pp2","22");
        // req yok

        // exp hazirlanması
        JSONObject expData= JPHDatas.expDataOlustur();

        // Response hazirlanmasi
        Response response = given().when().spec(specJPH).get("/{pp1}/{pp2}");

        JsonPath resJP=response.jsonPath();

        assertEquals(response.getStatusCode(),JPHDatas.basariliStatusCode);
        assertEquals(resJP.getInt("userId"),expData.get("userId"));
        assertEquals(resJP.getInt("id"),expData.get("id"));
        assertEquals(resJP.getString("title"),expData.get("title"));
        assertEquals(resJP.getString("body"),expData.get("body"));

    }
    @Test
    public void testDataKullanimi2() {
        specJPH.pathParams("pp1", "posts", "pp2", "22");

        JSONObject expData= JPHDatas.expDataOlusturParametreli(3,22,"dolor sint quo a velit explicabo quia nam","eos qui et ipsum ipsam suscipit aut\n" + "sed omnis non odio\n" + "expedita earum mollitia molestiae aut atque rem suscipit\n" + "nam impedit esse");
        //JSONObject expData2=JPHDatas.expDataOlusturParametreli()
        Response response=given().spec(specJPH).when().get("/{pp1}/{pp2}");
        JsonPath resJP=response.jsonPath();
        // response.prettyPrint();

        assertEquals(response.getStatusCode(),JPHDatas.basariliStatusCode);
        assertEquals(resJP.getInt("userId"),expData.get("userId"));
        assertEquals(resJP.getInt("id"),expData.get("id"));
        assertEquals(resJP.getString("title"),expData.get("title"));
        assertEquals(resJP.getString("body"),expData.get("body"));
    }

}
