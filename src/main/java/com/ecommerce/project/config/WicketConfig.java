package com.ecommerce.project.config;

import com.ecommerce.project.wicket.WicketWebApp;
import jakarta.servlet.Filter;
import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class WicketConfig {

    @Bean
    public FilterRegistrationBean<WicketFilter> wicketFilter() {
        FilterRegistrationBean<WicketFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new WicketFilter());
        registration.setName("Wicket-Filter");
        registration.addUrlPatterns("/*");

        registration.setInitParameters(Map.of(
                "applicationClassName", WicketWebApp.class.getName(),
                "filterMappingUrlPattern", "/*"
        ));

        registration.setAsyncSupported(true);
        return registration;
    }
}
