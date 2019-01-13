package com.test.cloud;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.entities.Product;
import com.test.entities.ProductDetails;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("/rest/product")
public class ProductResource {
   /* static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier(){

                    public boolean verify(String hostname,
                                          javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("localhost")) {
                            return true;
                        }
                        return false;
                    }
                });
    }*/


    @Autowired
    private RestTemplate restTemplate;


  /*  @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread"
            )*/
    //String hostAndPort = "localhost:8443";
    String hostAndPort ="product-mgmt-service";
    @GetMapping("/rest/product/getProducts/{productType}")
    public List<Product> getProducts(@PathVariable(value = "productType", required = true) String productType) {
        String url = "https://"+hostAndPort+"/service/productservice/getproducts/"+productType;
        System.out.println("url:: " +url);
        HttpEntity<String> requestEntity = new HttpEntity<>(createHeaders("admin","admin"));
        ResponseEntity<Product[]> responseEntity = restTemplate.exchange(url,HttpMethod.GET,requestEntity,Product[].class);
        Product[] products = responseEntity.getBody();
        System.out.println("Got All products:: ");
        List<Product> productList = Arrays.asList(products);
        productList.forEach(System.out::println);
        return productList;
    }

    @PostMapping (value = "/rest/product/addproduct", consumes = {
            "application/json" })
    public Boolean addProduct(@RequestBody(required = true) @Valid ProductDetails product) {
        ResponseEntity<?> responseEntity = null;
        try {

            String url = "https://"+hostAndPort+"/service/productservice/addproduct";
            System.out.println("url:: " + url);

            HttpEntity<ProductDetails> requestEntity = new HttpEntity<>(product, createHeaders("admin", "admin"));

            responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ProductDetails.class);

            if (responseEntity.getStatusCodeValue() == 200) {
                System.out.println("Product Added successfully ");
                return Boolean.TRUE;
            }
        } catch(Exception e){
            System.out.println("Exception while adding :: " + e );
        }

        return Boolean.FALSE;
    }

    @DeleteMapping("/rest/product/deleteProducts/{productId}")
    public Boolean deleteProducts(@PathVariable(value = "productId", required = true) int productId) {
        String url = "https://"+hostAndPort+"/service/productservice/deleteproducts/"+productId;
        System.out.println("url:: " +url);
        HttpEntity<String> requestEntity = new HttpEntity<>(createHeaders("admin","admin"));
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url,HttpMethod.DELETE,requestEntity,Boolean.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            System.out.println("Product deleted successfully ");
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            setContentType(MediaType.APPLICATION_JSON);
        }};
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }

}
