package uk.cf.ac.nccteam11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@EnableConfigurationProperties
public class NcCteam11Application {

    public static void main(String[] args) {
        SpringApplication.run(NcCteam11Application.class, args);
    }

}
