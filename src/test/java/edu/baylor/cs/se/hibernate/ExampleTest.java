package edu.baylor.cs.se.hibernate;

import edu.baylor.cs.se.hibernate.model.Contest;
import edu.baylor.cs.se.hibernate.model.Person;
import edu.baylor.cs.se.hibernate.model.Team;
import edu.baylor.cs.se.hibernate.repository.ContestRepository;
import edu.baylor.cs.se.hibernate.repository.PersonRepository;
import edu.baylor.cs.se.hibernate.repository.TeamRepository;
import edu.baylor.cs.se.hibernate.services.SuperRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;





@SpringBootTest
public class ExampleTest {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ContestRepository contestRepository;
    @Autowired
    private TeamRepository teamRepository;

   // @Autowired
    private SuperRepository superRepository;

    @Transactional
    public void populate(){
//        Person person1 = new Person(type);
//        person1.setName("Mike");
//        person1.setBirthdate(new Date("01/02/1995"));
//        person1.setEmail("mike@gmail.com");
//        person1.setUniversity("Baylor University");
//
//        Person person2 = new Person(type);
//        person2.setName("John");
//        person2.setBirthdate(new Date("02/03/1996"));
//        person2.setEmail("john@gmail.com");
//        person2.setUniversity("Baylor University");
//
//        Person person3 = new Person(type);
//        person3.setName("Alex");
//        person3.setBirthdate(new Date("03/02/1995"));
//        person3.setEmail("alex@gmail.com");
//        person3.setUniversity("Baylor University");
//
//        Person person4 = new Person(type);
//        person4.setName("Sara");
//        person4.setBirthdate(new Date("10/03/1996"));
//        person4.setEmail("sara@gmail.com");
//        person4.setUniversity("Baylor University");
//
//        Person person5 = new Person(type);
//        person5.setName("Becca");
//        person5.setBirthdate(new Date("02/03/1994"));
//        person5.setEmail("becca@gmail.com");
//        person5.setUniversity("Baylor University");
//
//        Person person6 = new Person(type);
//        person6.setName("Tim");
//        person6.setBirthdate(new Date("09/03/1994"));
//        person6.setEmail("tim@gmail.com");
//        person6.setUniversity("Baylor University");
//
//        Person person7 = new Person(type);
//        person7.setName("Misha");
//        person7.setBirthdate(new Date("09/02/1995"));
//        person7.setEmail("misha@gmail.com");
//        person7.setUniversity("Baylor University");
//
//        Person person8 = new Person(type);
//        person8.setName("Rhea");
//        person8.setBirthdate(new Date("09/03/1994"));
//        person8.setEmail("rhea@gmail.com");
//        person8.setUniversity("Baylor University");
//
//
//        ArrayList<Person> members1 = new ArrayList<>();
//        members1.add(person1);
//        members1.add(person2);
//        members1.add(person3);
//
//        ArrayList<Person> members2 = new ArrayList<>();
//        members2.add(person4);
//        members2.add(person5);
//        members2.add(person6);
//
//        ArrayList<Person> members3 = new ArrayList<>();
//        members3.add(person2);
//        members3.add(person4);
//        members3.add(person6);
//
//        ArrayList<Person> members4 = new ArrayList<>();
//        members4.add(person5);
//        members4.add(person7);
//        members4.add(person8);
//
//        ArrayList<Person> members5 = new ArrayList<>();
//        members5.add(person1);
//        members5.add(person3);
//        members5.add(person5);
//
//        Team team1 = new Team();
//        team1.setName("team_abc");
//        team1.setRank(10);
//        team1.setState(String.valueOf(State.StateEnum.Accepted));
//        team1.setMembers(members1);
//        team1.setMemberAsCoach(person8);
//        team1.setContestForTeams(null);
//
//        Team team2 = new Team();
//        team2.setName("team_def");
//        team2.setRank(20);
//        team2.setState(String.valueOf(State.StateEnum.Accepted));
//        team2.setMembers(members2);
//        team2.setMemberAsCoach(person7);
//        team2.setContestForTeams(null);
//
//        Team team3 = new Team();
//        team3.setName("team_xyz");
//        team3.setRank(30);
//        team3.setState(String.valueOf(State.StateEnum.Accepted));
//        team3.setMembers(members3);
//        team3.setMemberAsCoach(person1);
//        team3.setContestForTeams(null);
//
//        Team team4 = new Team();
//        team4.setName("team_abc1");
//        team4.setRank(40);
//        team4.setState(String.valueOf(State.StateEnum.Accepted));
//        team4.setMembers(members4);
//        team4.setMemberAsCoach(person3);
//        team4.setContestForTeams(null);
//
//        Team team5 = new Team();
//        team5.setName("team_xyz2");
//        team5.setRank(50);
//        team5.setState(String.valueOf(State.StateEnum.Accepted));
//        team5.setMembers(members5);
//        team5.setMemberAsCoach(person4);
//        team5.setContestForTeams(null);
//
//
//        //person1.setMembersInTeams(Collections.singletonList(team1));
//        person1.setMembersInTeams(Arrays.asList(team1));
//        person2.setMembersInTeams(Arrays.asList(team1));
//        person3.setMembersInTeams(Arrays.asList(team1));
//        person4.setMembersInTeams(Arrays.asList(team2));
//        person5.setMembersInTeams(Arrays.asList(team2));
//
//        person6.setMembersInTeams(Arrays.asList(team3));
//
//        person7.setMembersInTeams(Arrays.asList(team4));
//        person8.setMembersInTeams(Arrays.asList(team4));
////        person1.setMembersInTeams(Arrays.asList(team5));
////        person3.setMembersInTeams(Arrays.asList(team5));
////        person5.setMembersInTeams(Arrays.asList(team5));
////        person8.setTeamCoach(Arrays.asList(team1));
////        person7.setTeamCoach(Arrays.asList(team2));
////        person1.setTeamCoach(Arrays.asList(team3));
////        person3.setTeamCoach(Arrays.asList(team4));
////        person4.setTeamCoach(Arrays.asList(team5));
//
//
//
//
//        ArrayList<Team> teamsForContest = new ArrayList<>();
//        teamsForContest.add(team1);
//        teamsForContest.add(team2);
//        teamsForContest.add(team3);
//        teamsForContest.add(team4);
//        teamsForContest.add(team5);
//
//        Contest contest1 = new Contest();
//        contest1.setCapacity(10);
//        contest1.setDate(new Date("9/18/2022"));
//        contest1.setName("hacker rank");
//        contest1.setRegistration_allowed(true);
//        contest1.setTeamsInContest(teamsForContest);
//
//        team1.setContestForTeams(contest1);
//        team2.setContestForTeams(contest1);
//        team3.setContestForTeams(contest1);
//        team4.setContestForTeams(contest1);
//        team5.setContestForTeams(contest1);
//        person8.setManagerOfContest(Arrays.asList(contest1));
//
//
//        personRepository.save(person1);
//        personRepository.save(person2);
//        personRepository.save(person3);
//        personRepository.save(person4);
//        personRepository.save(person5);
//        personRepository.save(person6);
//        personRepository.save(person7);
//        personRepository.save(person8);
//        teamRepository.save(team1);
//        teamRepository.save(team2);
//        teamRepository.save(team3);
//        teamRepository.save(team4);
//        teamRepository.save(team5);
//        contestRepository.save(contest1);

    }
    @Test
    //simple test
    @Transactional
    public void demoTest1() {
        //superRepository.populate();
        populate();
        List<Team> getTeams = teamRepository.findAll();
        for (Team tm : getTeams) {
            System.out.println(tm.getName());
        }
    }

    @Test
    @Transactional
    public void demoTest2() {
        //superRepository.populate();
        populate();
        List<Person> getPersons = personRepository.findAll();
        HashMap<Integer, List<String>> mp = new HashMap<Integer, List<String>>();
        for(Person p: getPersons)
        {
            Date date = p.getBirthdate();
            int dateThen = date.getYear();
            Date d=new Date();
            int dateNow=d.getYear();
            int age =  dateNow - dateThen;

            String personName = p.getName();
            if (!mp.containsKey(age)) {
                List<String> list = new ArrayList<String>();
                list.add(personName);
                mp.put(age, list);
            } else {
                mp.get(age).add(personName);
            }
        }

        mp.forEach((key,value) -> System.out.println("Age " + key + " name of students " + value + " size " + value.size()));

    }

    @Test
    @Transactional
    public void demoTest3()
    {
        populate();
        List<Contest> contests = contestRepository.findAll();

        for (Contest c: contests)
        {
//            int noOfTeams = c.getTeamsInContest().size();
//            int capacity = c.getCapacity();
//            int occupancy = capacity - noOfTeams;
//            System.out.println("Occupancy = " + occupancy);

        }
    }




}
