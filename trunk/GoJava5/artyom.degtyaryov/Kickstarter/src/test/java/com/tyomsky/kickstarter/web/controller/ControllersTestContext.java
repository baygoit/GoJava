package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.service.CategoryService;
import com.tyomsky.kickstarter.service.QuoteService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllersTestContext {

    @Bean
    public QuoteService quoteService() {
        return Mockito.mock(QuoteService.class);
    }

    @Bean
    public CategoryService categoryService() {
        return Mockito.mock(CategoryService.class);
    }

}
