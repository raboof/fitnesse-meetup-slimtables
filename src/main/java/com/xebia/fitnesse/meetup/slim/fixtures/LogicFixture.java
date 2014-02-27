package com.xebia.fitnesse.meetup.slim.fixtures;

import javax.annotation.Resource;

import com.xebia.fitnesse.meetup.slim.spring.AbstractSpringScriptTable;
import com.xebia.fitnesse.meetup.slim.tables.ScriptTable;
import com.xebia.fitnesse.meetup.sut.GrantCalculationService;

public class LogicFixture extends AbstractSpringScriptTable {

    @Resource
    private GrantCalculationService grantCalculationService;

    public void whenWeCalculateTheGrants() {
        grantCalculationService.calculateGrants();
    }
}
