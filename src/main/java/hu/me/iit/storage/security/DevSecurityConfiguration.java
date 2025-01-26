package hu.me.iit.storage.security;


import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


//@Profile("dev")
@Order(SecurityProperties.BASIC_AUTH_ORDER)
@Configuration
@EnableWebSecurity
public class DevSecurityConfiguration {

    @Autowired
    private CustomUserdetailsService userDetails;
/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .anyRequest().authenticated()
                );;

        return httpSecurity.build();
    }

*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        String[] staticResources = new String[] {
                "/", "/index.html",
                "/login", "/404", "**/ /*bootstrap*"
        };

         /* http.csrf().disable();     .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
        .cors(cors -> cors.disable())
        */


        http
                .authorizeHttpRequests((requests) ->
                        requests.requestMatchers("/", "/cars", "/login", "/planes", "/cars/{id}","/planes/*", "/user", "/owners", "/index.html").permitAll()

                )

                .authorizeHttpRequests((requests) ->
                        requests.requestMatchers("/owners/{id}").hasAuthority("ROLE_ADMIN").anyRequest().authenticated()
                )
                .formLogin((form) -> form.loginPage("/login").permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .csrf(csrf -> csrf.disable())
        ;
        return http.build();
    }




    /*
    @Bean
    public AuthenticationManagerBuilder authenticationManagerBuilder(HttpSecurity http) throws Exception {
        var authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser(User.builder()
                        .username("admin2")
                        .password("{noop}adminpassword")
                        .roles("ADMIN")
                        .build());
        return authenticationManagerBuilder;
    }

*/








    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

     */

}
