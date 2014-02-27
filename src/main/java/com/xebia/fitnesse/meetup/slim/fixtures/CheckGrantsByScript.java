package com.xebia.fitnesse.meetup.slim.fixtures;

import javax.annotation.Resource;

import com.xebia.fitnesse.meetup.slim.spring.AbstractSpringScriptTable;
import com.xebia.fitnesse.meetup.slim.tables.ScriptTable;
import com.xebia.fitnesse.meetup.sut.GrantDao;

public class CheckGrantsByScript extends AbstractSpringScriptTable {
    @Resource
    private GrantDao grantDao;

    public int numberOfGrantsForParticipant(Long participantNumber) {
        return grantDao.getGrants(participantNumber).size();
    }

    public int valueOfGrantForParticipant(int index, Long participantNumber) {
        return grantDao.getGrants(participantNumber).get(index - 1).value;
    }
}
