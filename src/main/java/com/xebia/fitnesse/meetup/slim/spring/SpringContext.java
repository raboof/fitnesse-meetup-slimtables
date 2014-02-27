package com.xebia.fitnesse.meetup.slim.spring;

import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringContext {

    private final String contextLocation;

    private GenericApplicationContext context;
    private final AtomicBoolean contextInitialized = new AtomicBoolean(false);

    public SpringContext(String contextLocation) {
        this.contextLocation = contextLocation;
    }

    /**
     * Initialize the Spring context.
     */
    public void initialize() {
        context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(new ClassPathResource(contextLocation));
        context.refresh();
        contextInitialized.set(true);
    }

    /**
     * Close the Spring Context.
     */
    public void close() {
        if (contextInitialized.get()) {
            contextInitialized.set(false);
            context.close();
            context = null;
        }
    }

    /**
     * Autowire an object, specifically a FitNesse Fixture.
     *
     * @param toAutowire the bean to autowire
     */
    public void autowire(Object toAutowire) {
        checkInitialized();
        context.getBeanFactory().autowireBeanProperties(toAutowire, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
        context.getBeanFactory().initializeBean(toAutowire, toAutowire.getClass().getName());
    }

    public Object getBean(String name) {
        checkInitialized();
        return context.getBean(name);
    }

    /**
     * Check whether I'm initialized, else throw exception.
     *
     * @throws IllegalStateException When I'm not initialized
     */
    private void checkInitialized() {
        if (!contextInitialized.get()) {
            throw new IllegalStateException("Spring Context should be initialized!");
        }
    }
}
