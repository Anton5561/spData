package ru.denis.all.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class My_SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        //UserDetails userDetails = User.builder().username("den").password("den").roles("A1").build();
//        auth.inMemoryAuthentication().withUser(userBuilder.username("den").password("den").roles("A1"));
//        //auth.inMemoryAuthentication().withUser(userDetails);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //http.authorizeRequests().antMatchers("/api/all/**").authenticated()
        //http.authorizeRequests().antMatchers("/**").authenticated()

        http.csrf().disable().
                authorizeRequests().antMatchers("/login", "error", "/test").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/api/all", true)
                .failureUrl("/login?error")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/test")

                ;
//        http.authorizeRequests().antMatchers("/**").authenticated()
//                .and()
//                .formLogin()
//                ;
    }

    @Bean
    UserDetailsService users(){
        UserDetails user1 = User.builder().username("aaa").password("{noop}aaa").roles("A1").build();
        UserDetails user2 = User.builder().username("bbb").password("{bcrypt}$2a$12$IKZJsluOOT49G/zmWd01suU2v09UXCFHYLPVlihcgq1vjBEYPDVWK").roles("A1").build();
        UserDetails user3 = User.builder().username("ccc").password("{noop}ccc").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }


}
