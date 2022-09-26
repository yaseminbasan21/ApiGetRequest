package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get03 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
     */

    @Test
    public void get01(){
       //1.Step:Set the Url
      //String url="https://jsonplaceholder.typicode.com/todos/23"; onerilmiyor

        spec.pathParams("first","todos","second",23);

       //2.Set the expected data

       //3.Step:Send the Request and get the response
        Response response= given().spec(spec).when().get("/{first}/{second}");
                                   //parantez icindeki spec URL'dir

        response.prettyPrint();

        //4.Step:Do Assertion

        //1.Yol
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));


        //2.Yol
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId",equalTo(2));

        /*
            Note 1: Assertion yaparken Java calısmayı durdurdugunda hata sonrası kodlar calısmaz
            Boylece hata sonrası assertion'lar hakkında bilgi sahibi olamayız
            Fakat hata oncesi assertion'lar gecmistir

            Note 2: Eger kodumuzu hata noktasında duracak sekilde yazarsak "Hard Assertion" yapmıs oluyoruz

            Note 3: Eger kodumuz hata sorasında durmayacak sekılde yazarsak "Soft Assertion" yapmıs oluyoruz

            Note 4: Eger coklu body() method'u icinde assert yaparsak "Hard Assert",
                   tek body() method'u icinde assert yaparsak "Soft Assert" yapmıs oluyoruz.
         */

    }
}
