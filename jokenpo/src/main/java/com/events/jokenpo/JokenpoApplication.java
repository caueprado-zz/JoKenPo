package com.events.jokenpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "com.events.jokenpo.domain.action")
public class JokenpoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokenpoApplication.class, args);
    }

}
