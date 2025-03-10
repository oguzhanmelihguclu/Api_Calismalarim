package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P11_GET_ResponseBodyTestListKullanimi {

      /*

    https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale url’ine
    bir GET request yolladigimizda
    donen Response’in
    status code’unun 200,
    ve content type’inin application/json,
    ve response body’sindeki
    eczane sayısıın sayisinin 6
    ve eczane’lerden birinin “DELİCE ECZANESİ”
    ve eczanele ilçelerinde icinde keskin ,karakeçili ve yahşihan degerlerinin oldugunu test edin.
 */

    @Test
    public void test11(){

        // ent point hazirlanir ( req yok)
        String url= "https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale";
        String apikey="apikey 18Pj6PvAsp6HajgcjsxVAa:3KHSpVlF1gvdPM0Ryz6v0o";

        // exp hazirlanir

        // response hazirlanir
        Response response = given().when().header("authorization",apikey).get(url);
        response.prettyPrint();


        // assertion yapilir

       response.then().assertThat().contentType("application/json").statusCode(200)
                .body("result.dist",hasSize(5),"result.name",hasItem("ENES ECZANESİ"),
                        "result.dist",hasItems("yahşihan","keskin"));




    }

}
