package cvs.interview.bookapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http.csrf(AbstractHttpConfigurer::disable).build();
        return http
            .requiresChannel(channel ->
                channel.anyRequest().requiresSecure())
            .authorizeRequests(authorize ->
                authorize.anyRequest().permitAll())
            .csrf(AbstractHttpConfigurer::disable)
            .build();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
}
