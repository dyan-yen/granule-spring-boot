package co.dyan.demo.granulespringboot;

import com.granule.CompressServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.granule", "co.dyan.demo.granulespringboot"})
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public ServletRegistrationBean granuleRegistration(CompressServlet compressServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(compressServlet);
        registration.addUrlMappings("/combined.js", "/combined.css");
        registration.setLoadOnStartup(1);
        return registration;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
