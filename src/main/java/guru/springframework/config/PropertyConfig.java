package guru.springframework.config;

import guru.springframework.morebeans.FakeDataSource;
import guru.springframework.morebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    // === Properties by Environment Variables ===
    // Usecase - tap into the spring environment to get env-vars
    // e.g getting passwords from os
    @Autowired
    Environment env;


    // === Properties by @ProperySource ===
    // @Value - get from @PropertySource

    @Value("${rvlt.username}") // currently overridden by env var RVLT_USERNAME in run..config
            String user;
    @Value("${rvlt.password}") // spring expression ${var}
            String password;
    @Value("${rvlt.dburl}")
    String url;

    @Value("${rvlt.jms.username}")
    String jmsUser;
    @Value("${rvlt.jms.password}")
    String jmsPassword;
    @Value("${rvlt.jms.dburl}")
    String jmsUrl;


    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        //fakeDataSource.setUser(env.getProperty("USERNAME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }


    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setUrl(jmsUrl);
        return fakeJmsBroker;
    }


    // Bean config - Configurer provider into context
    // PSPC is what reads and scans the property files
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
