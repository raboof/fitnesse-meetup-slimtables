package com.xebia.fitnesse.meetup.slim.fixtures;

import static com.xebia.fitnesse.meetup.sut.GrantType.FOO;

import javax.annotation.Resource;

import com.xebia.fitnesse.meetup.slim.spring.AbstractSpringDecisionTable;
import com.xebia.fitnesse.meetup.slim.spring.AbstractSpringScriptTable;
import com.xebia.fitnesse.meetup.sut.GrantCalculationService;
import com.xebia.fitnesse.meetup.sut.GrantType;

public class GrantLogicByScriptTable extends AbstractSpringScriptTable {
    @Resource
    private GrantCalculationService grantCalculationService;

    public int grantValueForParticipantAgedForType(int age, GrantType type) {
        return grantCalculationService.determineAmount(age, type);
    }
}
