package uk.cf.ac.nccteam11.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
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
                .usersByUsernameQuery("select email, password, enabled from user where email = ?")
                .authoritiesByUsernameQuery("select email, role from user where email = ?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests

                                .mvcMatchers("/admin/**").authenticated()
                                .mvcMatchers("/user/**").authenticated()
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
}