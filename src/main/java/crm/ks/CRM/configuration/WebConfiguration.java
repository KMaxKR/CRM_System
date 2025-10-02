package crm.ks.CRM.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(req -> req
//                        .requestMatchers("").authenticated()
//                        .requestMatchers("").permitAll()
//                )
//                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll);
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
