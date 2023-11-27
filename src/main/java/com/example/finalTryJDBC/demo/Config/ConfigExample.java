package com.example.finalTryJDBC.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

@Configuration
//configuration class means it will override some of the original autoconfigured beans.
public class ConfigExample {

    @Bean(name = "rt_without_certificate")
    @Primary
    //If otherRestTemplate is also configured , this would be used as primary one , to use other one use @Qualifier
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

//    @Bean(name="rt_with_certificate")
//    public RestTemplate restTemplate()
//    {
//        return new RestTemplate(); //Here we suppose added certificate details too.
//    }

//so now it would have taken these beans with property set instead of deffault configuration beans.

