package com.test.cloud;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;

//@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class ProductClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductClientApplication.class, args);
	}
}


@Configuration
class Config {

	private String allPassword = "password";

	//@LoadBalanced
	//@Bean
	/*public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) throws Exception {

		SSLContext sslContext = SSLContextBuilder
				.create()
				.loadKeyMaterial(ResourceUtils.getFile("classpath:mycert.jks"), allPassword.toCharArray(), allPassword.toCharArray())
				.loadTrustMaterial(ResourceUtils.getFile("classpath:mycert.jks"), allPassword.toCharArray())
				.build();

		HttpClient client = HttpClients.custom()
				.setSSLContext(sslContext)
				.build();

		return builder
				.requestFactory(new HttpComponentsClientHttpRequestFactory(client)).build();
	}
}