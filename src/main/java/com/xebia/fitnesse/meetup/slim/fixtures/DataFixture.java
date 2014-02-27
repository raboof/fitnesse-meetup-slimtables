package com.xebia.fitnesse.meetup.slim.fixtures;

import javax.annotation.Resource;

import com.xebia.fitnesse.meetup.slim.spring.AbstractSpringScriptTable;
import com.xebia.fitnesse.meetup.sut.GrantDao;
import com.xebia.fitnesse.meetup.sut.ParticipantDao;

public class DataFixture extends AbstractSpringScriptTable {
    @Resource
    private ParticipantDao participantDao;
    @Resource
    private GrantDao grantDao;

    public void resetData() {
        participantDao.reset();
        grantDao.reset();
    }
}
