package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification spec; //request'lerimizi spesifik olarak atamamızı saglıyor,hangi base Url uzerinde yogunlasıcam,
    //burda deklare ettikten sonra methodumun icinde assign ediyorum
    //protected da public de heryerden ulasılabilir ,ancak protected yaptıgımızda extends etmemiz gerekir ulasmak istiyorsak

    //@Before annotation'ı kullandıgımız methodlar her Test metodundan once calısır
    @Before
    public void setUp(){

        spec=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }


    //RequestSpecification bir interface, interface'lerde constructor olusturamıyoruz,obje olusturamıyoruz
    //ama bir alt class'ından constructor olusturabiliriz RequestSpecBuilder
}
