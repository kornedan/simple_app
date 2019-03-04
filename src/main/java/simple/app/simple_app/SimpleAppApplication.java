package simple.app.simple_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.properties")
@SpringBootApplication
public class SimpleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleAppApplication.class, args);
    }

}
