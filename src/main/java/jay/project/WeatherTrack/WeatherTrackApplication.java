package jay.project.WeatherTrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WeatherTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherTrackApplication.class, args);
	}

    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
                        .allowedOrigins("https://weathertrack-angular.herokuapp.com", "http://localhost:4200");
			}
		};
	}
}
