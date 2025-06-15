package datawarehouse.wareouse.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite a todos los endpoints
                        // .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5500", "http://0.0.0.0:5050")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*");
                        // .allowCredentials(true);
            }
        };
    }
}