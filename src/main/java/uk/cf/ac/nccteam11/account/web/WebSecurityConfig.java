package uk.cf.ac.nccteam11.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.DefaultLoginPageConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//package uk.cf.ac.nccteam11.account.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class WebSecurityConfig{
//
//    @Autowired
//    private DataSource dataSource;
//    AuthenticationManagerBuilder authenticationManagerBuilder;
//
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select email, password from user where email=?")
//        ;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll();
//        return null;
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("select email, password from user where email = ?")
                .authoritiesByUsernameQuery("select email, role from user where email = ?");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.removeConfigurer(DefaultLoginPageConfigurer.class);
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .mvcMatchers("/admin/**").permitAll()
                                .mvcMatchers("/css/**").permitAll()
                                .mvcMatchers("/").permitAll()
                                .mvcMatchers("/sign-up").permitAll()
                                .mvcMatchers("/recycling").permitAll()
                                .mvcMatchers("/repair-cafes-list").permitAll()
                                .anyRequest().denyAll()
                )
                .formLogin(formLogin ->
                        formLogin
                                .permitAll()
                ).logout(logout ->
                        logout
                                .permitAll());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}