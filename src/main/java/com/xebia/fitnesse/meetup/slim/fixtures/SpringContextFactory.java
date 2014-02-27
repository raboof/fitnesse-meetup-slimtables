package com.xebia.fitnesse.meetup.slim.fixtures;

import com.xebia.fitnesse.meetup.slim.spring.SpringContext;

public final class SpringContextFactory {

    private static final Object MUTEX = new Object();

    private static SpringContext currentSpringContext;

    public static SpringContext currentSpringContext() {
        synchronized (MUTEX) {
            if (currentSpringContext == null) {
                throw new IllegalStateException("Spring context should be initialized first");
            }

            return currentSpringContext;
        }
    }

    public SpringContext createSpringContextIfNeeded(String contextLocation) {
        synchronized (MUTEX) {
            SpringContext currentContext = currentSpringContext;
            if (currentContext == null) {
                currentSpringContext = createNewSpringContext(contextLocation);
                return currentSpringContext;
            } else {
                return currentContext;
            }
        }
    }

    private SpringContext createNewSpringContext(String contextLocation) {
        SpringContext newSpringContext = new SpringContext(contextLocation);
        try {
            newSpringContext.initialize();
            return newSpringContext;
        } catch (Throwable t) {
            throw new StopTestException("Failed to initialize Spring", t);
        }
    }
}
