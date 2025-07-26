package com.github.theinfinity007.springhibernatebootcourse.restcrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    /*
    // Add support for JDBC for the users basic authorization.
    // Spring boot will use the default table, i.e users and authorities for the user creds and roles
    @Bean
    public UserDetailsManager jdbcUserDetailsManager(DataSource datasource){
        // telling spring boot to use the JDBC authentication with our data source
        return new JdbcUserDetailsManager(datasource);
    }
    */

    // Add support for JDBC for the users basic authorization.
    // Spring boot will use the default table, i.e users and authorities for the user creds and roles
    @Bean
    public UserDetailsManager jdbcCustomUserDetailsManager(DataSource datasource){
        // telling spring boot to use the JDBC authentication with our data source
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(datasource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pwd, enabled from members where user_id = ?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles where user_id = ?");

        return jdbcUserDetailsManager;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
        );

        // Use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable csrf
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE, patch
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    /*
    // Setup in memory users details, commenting it as we are now using jdbc user and authorities tables now.
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder().username("john").password("{noop}test123")
                .roles("EMPLOYEE").build();

        UserDetails mary = User.builder().username("mary").password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER").build();

        UserDetails susan = User.builder().username("susan").password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN").build();


        return new InMemoryUserDetailsManager(john, mary, susan);
    }
    */


}
