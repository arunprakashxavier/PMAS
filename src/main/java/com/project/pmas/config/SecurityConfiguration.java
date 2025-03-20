package com.project.pmas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration{

    @Bean
    public  UserDetailsService userDetailsService(){
        return new PatientDetailsService();
        // Below data is for testing purposes
//        UserDetails user = User.withUsername("Ram").password("{noop}123").roles("USER").build();
//        UserDetails admin = User.withUsername("Raman").password("{noop}1234").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( // Allow public access to Swagger UI and API docs
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()
                        .requestMatchers( // Allow other public pages
                                "/web/patients/login",
                                "/web/patients/register",
                                "/web/patients/savePatient",
                                "/web/doctors/register",
                                "/web/doctors/saveDoctor",
                                "/doctors/getAll",
                                "/doctors/get/{id}",
                                "/css/**",
                                "/js/**"
                        ).permitAll()
                        .requestMatchers(HttpMethod.POST, "/doctors/add", "/doctors/addAll").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/doctors/update/{id}").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/doctors/delete/{id}").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/web/patients/login")
                        .defaultSuccessUrl("/web/patients/home", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/web/patients/login?logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
