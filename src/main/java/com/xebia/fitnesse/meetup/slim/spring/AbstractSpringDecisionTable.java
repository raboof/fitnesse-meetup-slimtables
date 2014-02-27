package com.xebia.fitnesse.meetup.slim.spring;

import static com.xebia.fitnesse.meetup.slim.fixtures.SpringContextFactory.currentSpringContext;

import com.xebia.fitnesse.meetup.slim.tables.DecisionTable;

public abstract class AbstractSpringDecisionTable implements DecisionTable {
    public AbstractSpringDecisionTable() {
        currentSpringContext().autowire(this);
    }
}
