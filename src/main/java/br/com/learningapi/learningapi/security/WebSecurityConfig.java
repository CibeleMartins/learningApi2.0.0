package br.com.learningapi.learningapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import br.com.learningapi.learningapi.domain.repository.UserLearnerRepository;


@Configuration
@EnableWebSecurity //diz que é um config de segurança web
public class WebSecurityConfig implements WebMvcConfigurer {
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserLearnerRepository userLearnerRepository;
    
    @Autowired
    private AuthenticationConfiguration authConfiguration;

    @Autowired
    private UserDetailsSecurityServer userDetails;

    @Bean //p poder usar em qualquer lugar
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        // quando for solicitado uma config de authnetication manager com base no authentication configuration será retornado
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // desabilita algumas coisas e para cada requisição toma uma ação
        http.headers().frameOptions()
        .disable().and().cors().and()
        .csrf().disable().authorizeHttpRequests((auth) -> auth.requestMatchers(HttpMethod.POST, "/api/users").permitAll().anyRequest().authenticated()).sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // qualquer outra requisição que não seja POST vai precisar estar autenticado para conseguir fazer
        
        http.addFilter(new JwtAuthenticationFilter(authenticationManager(authConfiguration), jwtUtil, userLearnerRepository));
        http.addFilter(new JwtAuthorizationFilter(authenticationManager(authConfiguration), jwtUtil, userDetails));

        return http.build();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}