package edu.baylor.cs.se.hibernate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "personId", nullable = false)
    private Long personId;

    @Column(name = "birthdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date birthdate;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "university")
    private String university;

//    @ManyToMany
//    private List<Team> membersInTeams;

//    @OneToMany(targetEntity=Team.class, mappedBy="MemberAsCoach",cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
//    private List<Team> teamCoach;

//    @ManyToMany
//    @JoinColumn(name = "contestId", referencedColumnName = "contestId")
//    private List<Contest> managerOfContest;


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

//    public List<Team> getTeamCoach() {
//        return teamCoach;
//    }
//
//    public void setTeamCoach(List<Team> teamCoach) {
//        this.teamCoach = teamCoach;
//    }

//    public List<Contest> getManagerOfContest() {
//        return managerOfContest;
//    }
//
//    public void setManagerOfContest(List<Contest> managerOfContest) {
//        this.managerOfContest = managerOfContest;
//    }


}
