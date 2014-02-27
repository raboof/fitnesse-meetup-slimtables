package com.xebia.fitnesse.meetup.slim.fixtures;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.xebia.fitnesse.meetup.slim.spring.AbstractSpringQueryTable;
import com.xebia.fitnesse.meetup.sut.Grant;
import com.xebia.fitnesse.meetup.sut.GrantDao;

public class GrantsQueryTable extends AbstractSpringQueryTable {

    @Resource
    private GrantDao grantDao;

    private final Long participantNumber;

    public GrantsQueryTable() {
        this(null);
    }

    public GrantsQueryTable(Long participantNumber) {
        this.participantNumber = participantNumber;
    }

    @Override
    public List<List<List<String>>> query() throws Exception {
        return newArrayList(transform(queryGrants(), flatten()));
    }

    private Function<Grant, List<List<String>>> flatten() {
        return new Function<Grant, List<List<String>>>() {
            @Override
            public List<List<String>> apply(Grant grant) {
                return newArrayList(
                        field("participant", grant.participant.participantNumber),
                        field("value", grant.value),
                        field("grant type", grant.grantType),
                        field("is funky", grant.funky),
                        field("comment", grant.comment)
                );
            }
        };
    }

    private List<String> field(String column, Object value) {
        return newArrayList(column, String.valueOf(value));
    }

    private Collection<Grant> queryGrants() {
        if (participantNumber == null) {
            return grantDao.findAll();
        } else {
            return grantDao.getGrants(participantNumber);
        }
    }
}
