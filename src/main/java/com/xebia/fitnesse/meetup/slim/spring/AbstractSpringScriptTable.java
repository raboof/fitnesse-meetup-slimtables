package com.xebia.fitnesse.meetup.slim.spring;

import static com.xebia.fitnesse.meetup.slim.fixtures.SpringContextFactory.*;

import com.xebia.fitnesse.meetup.slim.fixtures.SpringContextFactory;
import com.xebia.fitnesse.meetup.slim.tables.ScriptTable;

public abstract class AbstractSpringScriptTable implements ScriptTable {
    public AbstractSpringScriptTable() {
        currentSpringContext().autowire(this);
    }
}
