package edu.baylor.cs.se.hibernate;


import lombok.Data;

@Data
public class State {
    private final StateEnum stateEnum;

    public static enum StateEnum {
        Accepted,Pending,Canceled
    }
}
