import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.mock.web.MockServletContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.epic.app")
@PropertySource({
        "classpath:database.properties",
        "classpath:debug.properties"
})
@ImportResource({
        "classpath:hibernate.xml",
        "classpath:spring-basic.xml"
})
@EnableAspectJAutoProxy
public class SpringTestConfiguration {
    @Bean // for @PropertySource work
    public PropertySourcesPlaceholderConfigurer pspc(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MockServletContext servletContext() {
        return new MockServletContext();
    }
}