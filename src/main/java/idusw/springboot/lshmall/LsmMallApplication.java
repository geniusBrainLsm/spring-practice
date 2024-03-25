package idusw.springboot.lshmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication // Spring - Annotation : java, lombok, spring
//@Configuration
//@EnableAutoConfiguration
public class LsmMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsmMallApplication.class, args);
    }


}
