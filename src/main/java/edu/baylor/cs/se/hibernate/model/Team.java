package edu.baylor.cs.se.hibernate.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Team  {
    @Id
    @GeneratedValue
    @Column(name = "teamId", nullable = true)
    private Long teamId;

    @Column(name = "name")
    private String name;

    @Column(name = "rank")
    private int rank;

    @Column(name = "state")
    private String state;

    //@JoinColumn(name = "teamId")
//    @OneToMany(targetEntity=Person.class,cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToMany
    private List<Person> members = new ArrayList<>(4);

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "personId", referencedColumnName = "personId")
    @ManyToOne
    @JoinColumn(name = "coach_personId", referencedColumnName = "personId")
    private Person MemberAsCoach;

    @ManyToOne
    @JoinColumn(name = "contestId", referencedColumnName = "contestId")
    private Contest contestForTeams;

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public Person getMemberAsCoach() {
        return MemberAsCoach;
    }

    public void setMemberAsCoach(Person memberAsCoach) {
        MemberAsCoach = memberAsCoach;
    }

    public Contest getContestForTeams() {
        return contestForTeams;
    }

    public void setContestForTeams(Contest contestForTeams) {
        this.contestForTeams = contestForTeams;
    }
}
