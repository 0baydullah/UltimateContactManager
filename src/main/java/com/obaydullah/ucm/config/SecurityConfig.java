package com.obaydullah.ucm.config;



import com.obaydullah.ucm.services.impl.SecurityCustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // create user and login with java code in memory service
//     @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("root")
//                .password("root")
//                .roles("ADMIN","USER")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//
//        var inMemoryUserDetailsService = new InMemoryUserDetailsManager(user1,user2);
//        return inMemoryUserDetailsService;
//    }

    @Autowired
    private SecurityCustomUserDetailService userDetailService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        // user detail service object

        daoAuthenticationProvider.setUserDetailsService(userDetailService);

        // password encoder object

        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
