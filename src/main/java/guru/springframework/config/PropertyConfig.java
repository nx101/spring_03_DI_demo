package guru.springframework.config;

import guru.springframework.morebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties") // Property source file
public class PropertyConfig {

    // Properties config
    @Value("${rvlt.username}") // Get from property source
    String user;
    @Value("${rvlt.password}") // spring expression ${var}
    String password;
    @Value("${rvlt.dburl}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }


    // Bean config - Configurer provider into context
    // PSPC is what reads and scans the property files
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
