package com.xebia.fitnesse.meetup.slim.fixtures;

import java.util.Random;

import javax.annotation.Resource;

import com.xebia.fitnesse.meetup.slim.spring.AbstractSpringScriptTable;
import com.xebia.fitnesse.meetup.slim.tables.ScriptTable;
import com.xebia.fitnesse.meetup.sut.Participant;
import com.xebia.fitnesse.meetup.sut.ParticipantDao;

public class CreateParticipantByScript extends AbstractSpringScriptTable {
    @Resource
    private ParticipantDao participantDao;

    private Participant participant;

    public void newParticipant() {
        participant = new Participant();
        participantDao.persist(participant);
    }

    private Participant getParticipant() {
        if (participant == null) {
            newParticipant();
        }
        return participant;
    }

    public void setFirstName(String firstName) {
        getParticipant().firstName = firstName;
    }

    public void setLastName(String lastName) {
        participant.lastName = lastName;
    }

    public Long getParticipantNumber() {
        return participant.participantNumber;
    }

}
