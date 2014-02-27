package com.xebia.fitnesse.meetup.slim.tables;

import java.util.Collection;
import java.util.List;

public interface QueryTable {
    List<List<List<String>>> query() throws Exception;
}
