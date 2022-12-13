package uk.cf.ac.nccteam11.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestRouter implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/repair-form").setViewName("repair-form");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("login").setViewName("login/login");
        registry.addViewController("/repair-cafe-add").setViewName("admin/repair-cafe-add");
        registry.addViewController("/repair-cafe-delete").setViewName("admin/repair-cafe-delete");
        registry.addViewController("/recycling").setViewName("recycling");
        registry.addViewController("/contactus").setViewName("contactus");
    }
}