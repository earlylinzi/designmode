package com.early.shejimoshi.diedaiqimoshi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcreteAggregate implements Aggregate{

    private List<Object> items = new ArrayList<Object>();


    public Iterator createIterator() {
        return null;
    }
}
