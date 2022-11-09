package edu.baylor.cs.se.hibernate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Contest  {
    @Id
    @GeneratedValue
    @Column(name = "contestId", nullable = false)
    private Long contestId;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date date;

    @Column(name = "name")
    private String name;

    @Column(name = "registration_allowed")
    private boolean registration_allowed;

    @Column(name = "registration_from")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date registration_from;

    @Column(name = "registration_to")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date registration_to;

    @Column(name = "writable")
    private boolean writable;

    public boolean isWritable() {
        return writable;
    }

//    public void setWritable(boolean writable) {
//        this.writable = writable;
//    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Contest superContest;

//    @ManyToMany(targetEntity =Person.class, mappedBy = "managerOfContest",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Person> memberAsManager;


    @OneToMany
    private List<Team> teamsInContest;

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRegistration_allowed() {
        return registration_allowed;
    }

    public void setRegistration_allowed(boolean registration_allowed) {
        this.registration_allowed = registration_allowed;
    }

    public Date getRegistration_from() {
        return registration_from;
    }

    public void setRegistration_from(Date registration_from) {
        this.registration_from = registration_from;
    }

    public Date getRegistration_to() {
        return registration_to;
    }

    public void setRegistration_to(Date registration_to) {
        this.registration_to = registration_to;
    }

    public Contest getSuperContest() {
        return superContest;
    }

    public void setSuperContest(Contest parentContest) {
        this.superContest = parentContest;
    }

    //    public List<Person> getMemberAsManager() {
//        return memberAsManager;
//    }
//
//    public void setMemberAsManager(List<Person> memberAsManager) {
//        this.memberAsManager = memberAsManager;
//    }

//    public List<Team> getTeamsInContest() {
//        return teamsInContest;
//    }
//
//    public void setTeamsInContest(List<Team> teamsInContest) {
//        this.teamsInContest = teamsInContest;
//    }
}
