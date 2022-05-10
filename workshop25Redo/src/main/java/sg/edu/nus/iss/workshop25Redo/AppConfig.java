package sg.edu.nus.iss.workshop25Redo;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sg.edu.nus.iss.workshop25Redo.filter.AuthenticationFilter;

@Configuration
public class AppConfig {
    
    @Bean
    public FilterRegistrationBean<AuthenticationFilter> registerFilters() {
        // Create an instance of authentication filter
        AuthenticationFilter authFilter = new AuthenticationFilter();

        // Create an instance of registration filter (want to filter the "/protected" path)
        FilterRegistrationBean<AuthenticationFilter> regFilter = new FilterRegistrationBean<>();
        regFilter.setFilter(authFilter);
        regFilter.addUrlPatterns("/protected/*");
        
        return regFilter;
    }
}
