/*package com.mindhub.eventhub.configs;

import com.mindhub.eventhub.models.Customer;
import com.mindhub.eventhub.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthSecurity extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputEmail -> {
            return customerRepository.findByEmail(inputEmail)
                .map(customer -> new User(customer.getEmail(), customer.getPassword(), AuthorityUtils.createAuthorityList("USER")))
                .orElseThrow(() -> new UsernameNotFoundException("Email invalid"));
        }).passwordEncoder(passwordEncoder());
    }
}*/

