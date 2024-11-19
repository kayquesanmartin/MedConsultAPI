package github.kayquesanmartin.MedConsultAPI.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public OpenAPI configOpenApi(){
        return new OpenAPI().info(
                new Info().description("A system for medical clinics where patients can schedule appointments, doctors can manage their schedules and administrators can view reports.")
                        .version("1.0.0")
                        .title("Medical Management System")
        );
    }

}
