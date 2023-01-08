package uk.cf.ac.nccteam11.account.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(102)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/sign-up");
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/recycling");
        web.ignoring().antMatchers("/repair-cafes-list");
        web.ignoring().antMatchers("/");
    }
}
