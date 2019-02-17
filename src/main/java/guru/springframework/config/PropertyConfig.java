package guru.springframework.config;

import guru.springframework.morebeans.FakeDataSource;
import guru.springframework.morebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
//@PropertySources({
//        @PropertySource("classpath:datasource.properties"),
//        @PropertySource("classpath:jms.properties")
//})

// @PropertySource(s) - refer to .properties files, requires a configurer bean

// === Using Spring Boot's properties file ===
// The modern way for boot apps.
// If properties are in Spring Boot's application.properties,
// the @Property annotation and configurer bean are *not* needed.
public class PropertyConfig {

    // === Properties by Environment Variables ===
    // Usecase - tap into the spring environment to get env-vars
    // e.g getting passwords from os
    @Autowired
    Environment env;

    // === Property value wiring ===
    // @Value("${property}")
    // e.g. can be overridden by env var RVLT_USERNAME in run..config
    @Value("${rvlt.username}")
    String user;
    @Value("${rvlt.password}")
    String password;
    @Value("${rvlt.url}")
    String url;

    @Value("${rvlt.jms.username}")
    String jmsUser;
    @Value("${rvlt.jms.password}")
    String jmsPassword;
    @Value("${rvlt.jms.url}")
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
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setUrl(jmsUrl);
        return fakeJmsBroker;
    }


    // Bean config - ProperySource(s) configurer
    // ** Required for @PropertySource
    // ** Not needed for Spring Boot's application.properties
    // PSPC is what reads and scans the property files
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
