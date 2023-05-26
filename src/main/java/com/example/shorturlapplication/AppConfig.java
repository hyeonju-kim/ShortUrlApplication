package com.example.shorturlapplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public List<String> illegalUrlList(){
        List<String> list = new ArrayList<>();
        list.add("naver");
        list.add("daum");
        return list;
    }

}
