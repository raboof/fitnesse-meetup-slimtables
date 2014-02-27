package com.xebia.fitnesse.meetup.sut;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class GrantCalculationService {
    @Resource
    private ParticipantDao participantDao;
    @Resource
    private GrantDao grantDao;
    
    public void calculateGrants() {
        for (Participant participant : participantDao.getParticipants()) {
            for (GrantType type : GrantType.values()) {
                grantDao.persist(calculateGrant(participant, type));
            }
        }
    }

    private Grant calculateGrant(Participant participant, GrantType type) {
        return new Grant(participant, type, determineAmount(participant.age, type));
    }

    public int determineAmount(int age, GrantType type) {
        switch(type) {
            case FOO:
                return 200;
            case BAR:
                return 300;
            default:
                return 0;
        }
    }
}
