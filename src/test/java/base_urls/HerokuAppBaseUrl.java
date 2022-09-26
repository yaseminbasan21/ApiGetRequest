package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


    public class HerokuAppBaseUrl{
        protected RequestSpecification spec;

        public void setUp(){

            spec=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/booking").build();

        }






}
