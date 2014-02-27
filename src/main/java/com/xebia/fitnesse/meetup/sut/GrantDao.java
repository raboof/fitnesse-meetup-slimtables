package com.xebia.fitnesse.meetup.sut;

import static com.google.common.collect.Collections2.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.springframework.stereotype.Repository;

@Repository
public class GrantDao {

    private List<Grant> grants;

    public void reset() {
        grants = new ArrayList<>();
    }

    public List<Grant> getGrants(final Long participantNumber) {
        return new ArrayList<>(filter(grants, new Predicate<Grant>() {
            @Override
            public boolean apply(Grant input) {
                return input.participant.participantNumber.equals(participantNumber);
            }
        }));
    }

    public void persist(Grant grant) {
        grants.add(grant);
    }

    public Collection<Grant> findAll() {
        return grants;
    }
}
