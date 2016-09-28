package example.jbot;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
// import org.springframework.core.env.PropertySource;
// import org.springframework.core.env.PropertySources;

// @ImportResource({"classpath:activiti-ui-context.xml", "classpath:activiti-login-context.xml", "classpath:activiti-custom-context.xml"})

// @SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "example.jbot"})
@Configuration
@ImportResource({"classpath:/application-context.xml"})
// @PropertySource("classpath:/application.properties")
@ComponentScan({"me.ramswaroop.jbot", "example.jbot"})
public class JBotApplication {

    /**
     * Entry point of the application. Run this method to start the sample bots,
     * but don't forget to add the correct tokens in application.properties file.
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JBotApplication.class);
        // SpringApplication.run(JBotApplication.class, args);
    }
}
