package com.test.cloud;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.entities.Product;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/product/client")
public class ProductResource {


    @Autowired
    private RestTemplate restTemplate;


  /*  @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread"
            )*/
    @GetMapping
    public Object hello() {
        String url = "https://localhost:8443/service/productservice/getproducts";
        System.out.println("url:: " +url);
        List<Product> entities = new ArrayList<>();
        Object obj = restTemplate.exchange
                (url, HttpMethod.GET, new HttpEntity<Product>(createHeaders("user", "password")), Product.class);
        System.out.println("obj:: "+obj);
        return obj;
        //return restTemplate.getForObject(url, String.class);
    }

    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }

}
