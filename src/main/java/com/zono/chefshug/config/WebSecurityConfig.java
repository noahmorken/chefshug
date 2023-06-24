package com.zono.chefshug.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    // @Bean 
    // public PasswordEncoder passwordEncoder() { 
    //     return new BCryptPasswordEncoder(); 
    // }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(
                (csrf) -> csrf.disable()
            )
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home", "/recipe/*").permitAll()
				.anyRequest().authenticated()
			)
            .formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
            )
            .logout((logout) -> logout.permitAll())
            .cors(withDefaults());

// .formLogin(withDefaults());        
//             .authorizeRequests()
//             .antMatchers("/admin/**")
//             .hasRole("ADMIN")
//             .antMatchers("/anonymous*")
//             .anonymous()
//             .antMatchers("/login*")
//             .permitAll()
//             .anyRequest()
//             .authenticated()
//             .and()
//             .formLogin()
//             .loginPage("/login.html")
//             .loginProcessingUrl("/perform_login")
//             .defaultSuccessUrl("/homepage.html", true)
//             .failureUrl("/login.html?error=true")
//             .failureHandler(authenticationFailureHandler())
//             .and()
//             .logout()
//             .logoutUrl("/perform_logout")
//             .deleteCookies("JSESSIONID")
//             .logoutSuccessHandler(logoutSuccessHandler());
        return http.build();
    }
}