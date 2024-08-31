package com.demo.SpringSecEx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.csrf(customizer -> customizer.disable());
//        //this alone will not provide security, as it will open without the login page
//        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//        // by adding above if we try to access it the site will show "Access to localhost was denied"
//        //http.formLogin(Customizer.withDefaults());
//        //by adding above it will show login page and by giving username and password provided it will work
//        http.httpBasic(Customizer.withDefaults());
//        //above gives to avoid form login html in postman which im not getting but telusko does
//        //we can disable if we dun want that http.formLogin
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        //above to make http stateless we can disable form formLogin and it will show pop up for login...but in postman it will be same but diff session id....
//        // if we disable the formLogin only pop up comes else the login form reloads again and again without opening the content
//        return http.build();

        // the below given set of codes is equivalent to http.csrf(customizer -> customizer.disable());
//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//                customizer.disable();
//            }
//        };
//        http.csrf(custCsrf);

        //http.authorizeHttpRequests();
        //http.httpBasic();

        // giving all codes above in a go...
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("register", "login") //implies for register and login we dun have to authenticate as basically they are permitted
                        .permitAll() // for all other requests it will be authenticated nd by default authentication is UserPasswordAuthentication (filter)
                        .anyRequest()
                        .authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }
//    // to use username and password on my own way besides the one in application properties
//    @Bean //bean will be the spring container and spring security will pick credentials from here
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("kiran")
//                .password("12345")
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("harsh")
//                .password("67890")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
//    // the above functn wont work for default values given in application.properties
//    //its bcoz here we r giving oue own functn for same
    // we cant use above functn as it will give onli user pref but returns the default json values we provide
    // so we r creating our own Authentication provider
    //there are multiple authentication providers..one of them is for db calles DaoAuthenticationProvider
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); //default password encoder NoOpPasswordEncoder that is no password encoder
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

        return config.getAuthenticationManager();

    }

}

// instead of UPAF(Username Password Authentication Filter) if we have JWTFilter
// at first and then UPAF is placed then it will evaluate
