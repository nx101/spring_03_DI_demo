package guru.springframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// Demo bean lifecycle - simple msg for each interface

/**
 * __ Runtime Order:
 * ## I'm in the LifeCycleBean Constructor
 * ## My Bean Name is: lifeCycleDemoBean
 * ## Bean Factory has been set
 * ## Application context has been set
 * ## - Before Init - Called by Bean Post Processor
 * ## The Post Construct annotated method has been called
 * ## The LifeCycleBean has its properties set!
 * ## - After init called by Bean Post Processor
 * 2019-02-03 18:23:15.438  INFO 15892 --- [           main] guru.springframework.DiDemoApplication   : Started DiDemoApplication in 0.771 seconds (JVM running for 1.591)
 * PrimaryInjectedController Hola - Primary GreetingRepositoryImpl es
 * PropertyInjectedController Hello - PropertyGreetingService
 * SetterInjectedController Hello - SetterGreetingService
 * ConstructorInjectedController Hello - ConstructorGreetingService
 * ## The Predestroy annotated method has been called
 * ## The Lifecycle bean has been terminated
 */


@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware{

    public LifeCycleDemoBean() {
        System.out.println("## I'm in the LifeCycleBean Constructor");
    }


    // By Callback interfaces - InitializingBean and DisposableBean

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleBean has its properties set!");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The Lifecycle bean has been terminated");

    }


    // By Aware interfaces - BeanNameAware, BeanFactoryAware, ApplicationContextAware

    @Override
    public void setBeanName(String name) {
        System.out.println("## My Bean Name is: " + name);

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## Bean Factory has been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application context has been set");
    }


    // By Lifecycle Annotations - @PostConstruct, @PreDestroy

    @PostConstruct
    public void postConstruct(){
        System.out.println("## The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## The Predestroy annotated method has been called");
    }


    // By Bean Post Processor - see CustomBeanPostProcessor implements BeanPostProcessor

    public void beforeInit(){
        System.out.println("## - Before Init - Called by Bean Post Processor");
    }

    public void afterInit(){
        System.out.println("## - After init called by Bean Post Processor");
    }
}