package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class P03_jSONDataOlusturma {

      /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

	{
	"title":"Ahmet",
	"body":"Merhaba",
	"userId":1
	}

     */

    @Test
    public void test02() {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title","Oguzhan");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",1);

        System.out.println(jsonObject);
    }

     /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
     "firstname":"Jim",
     "additionalneeds":"Breakfast",
     "bookingdates": {
             "checkin":"2018-01-01",
             "checkout":"2019-01-01"
	},
      "totalprice":111,
      "depositpaid":true,
      "lastname":"Brown"
    }
      Bu gibi iç içe veri bulunduran datalarla çalışırken önce en içerdekinden başlanır
  */
    @Test
    public void test03(){

        // inner data olusturma
        JSONObject innerData=new JSONObject();

        innerData.put("checkin","2018-01-01");
        innerData.put("checkout","2019-01-01");

        // data olusturma
        JSONObject data =new JSONObject();

        data.put("firstname","Jim");
        data.put("additionalneeds","Breakfast");
        data.put("bookingdates",innerData);
        data.put("totalprice",111);
        data.put("depositpaid",true);
        data.put("lastname","Brown");

        System.out.println(data);

    }



}
