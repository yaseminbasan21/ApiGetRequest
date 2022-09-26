package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void Get01(){

        //1.Step Set the Url
        String url="https://restful-booker.herokuapp.com/booking/15555";

        //2.Step: Set the expected data(Post-Put-Patch)   2. adımı get de yapmıyoruz

        //3.Step:Type code send to request
        Response response=given().when().get(url);     //burda normalde test passed olmalı ama ben de failed oluyo sebebi baska biseyden kaynaklanıyo bulmam lazım
                                                      //response bizim body'miz
        response.prettyPrint();

        //4.Step:Do Assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //Response body'de bulunan spesifik bir veri nasıl assert edilir:
        //assertTrue() methodu parantezin içindeki değer true ise testi geçirir.
        assertTrue(response.asString().contains("Not Found")); //asString string olarak demek

        //Response body'de spesifik bir veri bulunmadığını nasıl assert edilir:
        //assertFalse() methodu parantezin içindeki değer false is testi geçirir.
        assertFalse(response.asString().contains("TechProEd"));

        //assertEquals() methodu parantez içindeki iki değer eşit ise testi geçirir.
        assertEquals("Cowboy",response.header("Server"));

    }


}
