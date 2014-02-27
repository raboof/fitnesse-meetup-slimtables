package com.xebia.fitnesse.meetup.slim.fixtures;

import javax.annotation.Resource;

import com.xebia.fitnesse.meetup.slim.spring.AbstractSpringDecisionTable;
import com.xebia.fitnesse.meetup.slim.spring.AbstractSpringScriptTable;
import com.xebia.fitnesse.meetup.sut.Participant;
import com.xebia.fitnesse.meetup.sut.ParticipantDao;

public class CreateParticipantsByDecisionTable extends AbstractSpringDecisionTable {
    @Resource
    private ParticipantDao participantDao;

    private Participant participant;

    @Override
    public void reset() throws Exception {
        participant = new Participant();
    }

    public void setFirstName(String firstName) {
        participant.firstName = firstName;
    }

    public void setLastName(String lastName) {
        participant.lastName = lastName;
    }

    @Override
    public void execute() throws Exception {
          participantDao.persist(participant);
    }

    public Long participantNumber() {
        return participant.participantNumber;
    }
}
