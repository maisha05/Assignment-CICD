package edu.baylor.cs.se.hibernate.services;

import edu.baylor.cs.se.hibernate.State;
import edu.baylor.cs.se.hibernate.model.Contest;
import edu.baylor.cs.se.hibernate.model.Person;
import edu.baylor.cs.se.hibernate.model.Team;
import edu.baylor.cs.se.hibernate.repository.ContestRepository;
import edu.baylor.cs.se.hibernate.repository.PersonRepository;

import edu.baylor.cs.se.hibernate.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContestService {
    private ContestRepository contestRepository;
    private TeamRepository teamRepository;
    private PersonRepository personRepository;
    @Autowired
    public ContestService(ContestRepository contestRepository, TeamRepository teamRepository, PersonRepository personRepository)
    {
        this.contestRepository = contestRepository;
        this.teamRepository = teamRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public void populate()
    {
        Contest contest1 = new Contest();
        contest1.setCapacity(3);
        contest1.setDate(new Date("08/02/2022"));
        contest1.setName("hacker rank");
        contest1.setRegistration_allowed(true);
        contest1.setRegistration_from(new Date("06/02/2022"));
        contest1.setRegistration_to(new Date("07/30/2022"));
        contestRepository.save(contest1);

        Contest contest2 = new Contest();
        contest2.setCapacity(2);
        contest2.setDate(new Date("06/02/2022"));
        contest2.setName("hacker rank Preli");
        contest2.setRegistration_allowed(true);
        contest2.setRegistration_from(new Date("04/02/2022"));
        contest2.setRegistration_to(new Date("05/30/2022"));
        contest2.setSuperContest(contest1);
        contestRepository.save(contest2);

        Team team3 = new Team();
        team3.setName("team_xyz");
        team3.setRank(10);
        team3.setState(String.valueOf(State.StateEnum.Pending));
        team3.setContestForTeams(contest2);
        teamRepository.save(team3);

        Team team4 = new Team();
        team4.setName("team_abc");
        team4.setRank(3);
        team4.setState(String.valueOf(State.StateEnum.Pending));
        team4.setContestForTeams(contest2);
        //teamRepository.save(team4);

        Team team2 = new Team();
        team2.setName("coders");
        team2.setRank(30);
        team2.setState(String.valueOf(State.StateEnum.Pending));
        team2.setContestForTeams(contest1);
        teamRepository.save(team2);

        Person person1 = new Person();
        person1.setName("Mike");
        person1.setBirthdate(new Date("01/02/1999"));
        person1.setEmail("mike@gmail.com");
        person1.setUniversity("Baylor University");
        personRepository.save(person1);

        Person person2 = new Person();
        person2.setName("May");
        person2.setBirthdate(new Date("01/02/1999"));
        person2.setEmail("may@gmail.com");
        person2.setUniversity("Baylor University");
        personRepository.save(person2);

        Person person3 = new Person();
        person3.setName("Mini");
        person3.setBirthdate(new Date("01/02/1999"));
        person3.setEmail("mini@gmail.com");
        person3.setUniversity("Baylor University");
        personRepository.save(person3);

        Person person4 = new Person();
        person4.setName("Mish");
        person4.setBirthdate(new Date("01/02/1999"));
        person4.setEmail("mish@gmail.com");
        person4.setUniversity("Baylor University");
        personRepository.save(person4);

        Person person5 = new Person();
        person5.setName("Becca");
        person5.setBirthdate(new Date("02/03/1999"));
        person5.setEmail("becca@gmail.com");
        person5.setUniversity("Baylor University");
        personRepository.save(person5);

        Person person6 = new Person();
        person6.setName("Tim");
        person6.setBirthdate(new Date("09/03/1999"));
        person6.setEmail("tim@gmail.com");
        person6.setUniversity("Baylor University");
        personRepository.save(person6);

        Person person7 = new Person();
        person7.setName("Misha");
        person7.setBirthdate(new Date("09/02/1999"));
        person7.setEmail("misha@gmail.com");
        person7.setUniversity("Baylor University");
        personRepository.save(person7);

        Person person8 = new Person();
        person8.setName("Rhea");
        person8.setBirthdate(new Date("09/03/1999"));
        person8.setEmail("rhea@gmail.com");
        person8.setUniversity("Baylor University");
        personRepository.save(person8);


        ArrayList<Person> members1 = new ArrayList<>();
        members1.add(person5);
        members1.add(person6);
        members1.add(person7);

        team4.setMembers(members1);
        team4.setMemberAsCoach(person8);
        teamRepository.save(team4);
//
//        Contest contest3 = new Contest();
//        contest3.setCapacity(3);
//        contest3.setDate(new Date("08/02/2022"));
//        contest3.setName("hacker rank another");
//        contest3.setRegistration_allowed(true);
//        contest3.setRegistration_from(new Date("06/02/2022"));
//        contest3.setRegistration_to(new Date("07/30/2022"));
//        contestRepository.save(contest3);

    }

    public Contest createContest(Contest contest)
    {
        return contestRepository.save(contest);
    }

    public List<Contest> getAllContest() {return contestRepository.findAll(); }

    public Contest contestById(@PathVariable("id") Long id) {
        Optional<Contest> contest = contestRepository.findById(id);
        if (contest.isPresent()) {
            return contest.get();
        }
        else return null;
    }

    public Contest editContest(Contest contest)
    {
        Optional<Contest> optContest = contestRepository.findById(contest.getContestId());
        Contest con = new Contest();
        if(optContest.isPresent())
        {
            if(optContest.get().isWritable())
            {
                Contest updateContest = optContest.get();
               if(contest.getContestId() != null)
                   updateContest.setContestId(contest.getContestId());
               if(contest.getName() != null)
                   updateContest.setName(contest.getName());
                if(contest.getDate() != null)
                    updateContest.setDate(contest.getDate());
                if(contest.getCapacity() != 0)
                    updateContest.setCapacity(contest.getCapacity());
                if(contest.getRegistration_to() != null)
                    updateContest.setRegistration_to(contest.getRegistration_to());
                if(contest.getRegistration_from() != null)
                    updateContest.setRegistration_from(contest.getRegistration_from());

               con = contestRepository.save(updateContest);
            }
        }
        return con;
    }

    public int setContest(Long contestId)
    {
        return contestRepository.setWritable(contestId);
    }

    public int setReadonly(Long contestId)
    {
        return contestRepository.setReadonly(contestId);
    }

//    public Contest setReadonly(@PathVariable("id") Long id, Contest contest)
//    {
//        Long i = contest.getContestId();
//        Optional<Contest> optContest = contestRepository.findById(id);
//        Contest updateContest = new Contest();
//        if(optContest.isPresent())
//        {
//            contest.setWritable(false);
//            updateContest = contestRepository.save(contest);
//        }
//        return updateContest;
//    }


}


