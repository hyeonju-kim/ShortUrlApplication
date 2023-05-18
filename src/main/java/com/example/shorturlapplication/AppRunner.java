package com.example.shorturlapplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Value("${server.name}")
    private String serverName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=======NOW ENVIRONMENT===================");
        System.out.println(serverName);
    }
}
