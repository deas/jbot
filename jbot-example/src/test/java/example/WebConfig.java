package example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by deas on 10/1/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"me.ramswaroop.jbot", "example.jbot.slack"})
@ImportResource({"classpath:/application-context.xml"})
public class WebConfig {
}
