package com.learn.java.immutability;

import java.util.Date;

/**
 * All the java.lang packages are immutable classes
 * <p>
 * Rule 1 :- Make all the fields as private and final (final so it cannot be abused by reflection)
 * Rule 2 :- Don't provide setter methods
 * Rule 3 :- Make sure class shouldn't be overridden (private constructor and final class)
 * Rule 4 :- Protect mutable fields
 * Rule 5 :- Make deep copies of mutable data
 * Created by grijesh.
 */
public final class Employee {

    //Immutable
    private final String name;

    //Immutable
    private final long id;

    //Mutable
    private final Date dob;

    private Employee(Date dob, long id, String name) {
        this.dob = new Date(dob.getTime());
        this.id = id;
        this.name = name;
    }

    public Employee getEmployee(Date dob, long id, String name) {
        return new Employee(dob, id, name);
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Date getDob() {
        return new Date(dob.getTime());
    }
}
