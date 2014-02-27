package com.xebia.fitnesse.meetup.slim.spring;

import static com.xebia.fitnesse.meetup.slim.fixtures.SpringContextFactory.currentSpringContext;

import com.xebia.fitnesse.meetup.slim.tables.QueryTable;

public abstract class AbstractSpringQueryTable implements QueryTable {
    public AbstractSpringQueryTable() {
        currentSpringContext().autowire(this);
    }
}
