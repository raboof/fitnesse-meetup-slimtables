package com.xebia.fitnesse.meetup.slim.fixtures;

import static com.xebia.fitnesse.meetup.sut.GrantType.*;

import javax.annotation.Resource;

import com.xebia.fitnesse.meetup.slim.spring.AbstractSpringDecisionTable;
import com.xebia.fitnesse.meetup.sut.GrantCalculationService;
import com.xebia.fitnesse.meetup.sut.GrantType;

public class GrantLogicByDecisionTable extends AbstractSpringDecisionTable {
    @Resource
    private GrantCalculationService grantCalculationService;

    private int age;
    private GrantType grantType;

    private int value;

    @Override
    public void reset() throws Exception {
        this.age = 16;
        this.grantType = FOO;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrantType(GrantType grantType) {
        this.grantType = grantType;
    }

    @Override
    public void execute() throws Exception {
        this.value = grantCalculationService.determineAmount(age, grantType);
    }

    public int value() {
        return value;
    }
}
