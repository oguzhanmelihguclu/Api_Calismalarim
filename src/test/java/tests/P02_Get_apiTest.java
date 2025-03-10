package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P02_Get_apiTest {


      /*
    https://restful-booker.herokuapp.com/booking/10 url’ine
    bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
    ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */

    /*
   Tüm API sorguları 4 aşamada yapılır
       1-EndPonit hazırlanır(url ve varsa(PUT-POST-PATCH) request Body hazırlanır)
       2-Soruda verilmiş ise Expected Data hazırlanır. Verilmemişse hazırlanmaz
       3-Dönen cevap kaydedilir
       4-Assertion işlemleri yapılır

 */


    @Test
    public void test01() {

        // 1-EndPonit hazırlanır(url ve varsa(PUT-POST-PATCH) request Body hazırlanır)

        String url = " https://restful-booker.herokuapp.com/booking/10";

        // 2-Soruda verilmiş ise Expected Data hazırlanır. Verilmemişse hazırlanmaz

        // 3-Dönen cevap kaydedilir

        Response response = given().when().get(url);
        // Belirtilen URL'ye bir GET isteği gönder ve yanıtı al ve response objesine kaydet demek!!!


        //Assertion işlemleri yapılır

        response.then().assertThat().statusCode(200)
                                    .contentType("application/json; charset=utf-8")
                                    .header("Server","Cowboy")
                                    .statusLine("HTTP/1.1 200 OK");

        System.out.println("Test Başarı ile gerçekleşti...");


    }

}
