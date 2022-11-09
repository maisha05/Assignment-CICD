package edu.baylor.cs.se.hibernate.services;

import edu.baylor.cs.se.hibernate.model.*;
import edu.baylor.cs.se.hibernate.repository.ContestRepository;
import edu.baylor.cs.se.hibernate.repository.PersonRepository;
import edu.baylor.cs.se.hibernate.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;
import java.util.*;

@Service
public class TeamService {
    private TeamRepository teamRepository;
    private ContestRepository contestRepository;
    private PersonRepository personRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, ContestRepository contestRepository, PersonRepository personRepository)
    {
        this.teamRepository = teamRepository;
        this.contestRepository = contestRepository;
        this.personRepository = personRepository;
    }

    public Team createTeam(Team team)
    {
       List<Person> p = team.getMembers();
       for(Person p1 : p)
       {
           if(p1.getPersonId() == null)
           {
               personRepository.save(p1);
           }
       }
        return teamRepository.save(team);
    }

    public List<Team> getAllTeam() {return teamRepository.findAll(); }

    public Team teamById(@PathVariable("id") Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()) {
            return team.get();
        }
        else return null;
    }



//    public Team contestRegistration(ContestRegister contestRegister)
//    {
//        Team registerTeam = new Team();
//        Team team = contestRegister.getTeam();
//        Long contestId = contestRegister.getContestId();
//        Optional<Contest> contest = contestRepository.findById(contestId);
//        int noOfTeams=0;
//        List<Team> getTeams = teamRepository.findAll();
//        List<Long> list = new ArrayList<>();
//        if (contest.isPresent()) {
//            boolean flag = true;
//            for (Team tm : getTeams) {
//                Long cId = tm.getContestForTeams().getContestId();
//                if(cId == contestId)
//                {
//                    noOfTeams++;
//                    List<Person> member = tm.getMembers();
//                    for(Person p : member)
//                    {
//                        list.add(p.getPersonId());
//                    }
//
//                }
//            }
//            List<Person> member = team.getMembers();
//            Set<Person> allMemebers = new HashSet<>();
//            int cnt = 0;
//
//            for(Person p: member)
//            {
//                Long personId = p.getPersonId();
//                Optional<Person> p1 = personRepository.findById(personId);
//                Date date = p1.get().getBirthdate();
//                int dateThen = date.getYear();
//                Date d=new Date();
//                int dateNow=d.getYear();
//                int age =  dateNow - dateThen;
//                if(age < 24)
//                    cnt++;
//                if(list.contains(personId))
//                    flag = false;
//                allMemebers.add(p1.get());
//
//
//            }
//            Person coach = team.getMemberAsCoach();
//            if(!Objects.isNull(coach)) {
//                Optional<Person> optCoach = personRepository.findById(coach.getPersonId());
//                allMemebers.add(optCoach.get());
//                Date date = optCoach.get().getBirthdate();
//                int dateThen = date.getYear();
//                Date d = new Date();
//                int dateNow = d.getYear();
//                int age = dateNow - dateThen;
//                if (age < 24)
//                    cnt++;
//            }
//
//            int capacity = contest.get().getCapacity();
//            System.out.println("capacity " + capacity);
//            System.out.println("member size : " + allMemebers.size());
//            System.out.println("count  " + cnt);
//            System.out.println("flag " + flag);
//            System.out.println("teams " + noOfTeams);
//            if(capacity > noOfTeams && flag == true && cnt == 4 && allMemebers.size() == 4)
//            {
//                team.setContestForTeams(contest.get());
//                registerTeam = teamRepository.save(team);
//
//            }
//        }
//        return registerTeam;
//    }

    public String contestRegistration(Long conId, Team team)
    {

        Team registerTeam = new Team();
       // Team team = contestRegister.getTeam();
        Long contestId = conId;
        Optional<Contest> contest = contestRepository.findById(contestId);
        int noOfTeams=0;
        List<Team> getTeams = teamRepository.findAll();
        List<String> list = new ArrayList<>();
        if (contest.isPresent()) {
            if(!contest.get().isWritable())
                return "Contest can not writable.";
            if (contest.get().isWritable()) {
                boolean flag = true;
                for (Team tm : getTeams) {
                    if(tm.getContestForTeams() != null) {
                        Long cId = tm.getContestForTeams().getContestId();
                        if (cId == contestId) {
                            noOfTeams++;
                            List<Person> member = tm.getMembers();
                            for (Person p : member) {
                                list.add(p.getEmail());
                            }
                        }
                    }
                }
                List<Person> member = team.getMembers();
                Set<String> allMemebers = new HashSet<>();
                int cnt = 0;

                for (Person p : member) {
                    Long personId = p.getPersonId();
                    Date date;
                    String email;
                    if (personId != null) {
                        Optional<Person> p1 = personRepository.findById(personId);
                        date = p1.get().getBirthdate();
                        email = p1.get().getEmail();
                    } else {
                        date = p.getBirthdate();
                        email = p.getEmail();
                    }
                    int dateThen = date.getYear();
                    Date d = new Date();
                    int dateNow = d.getYear();
                    int age = dateNow - dateThen;
                    if (age < 24)
                        cnt++;
                    if (list.contains(email))
                        flag = false;
                    allMemebers.add(email);

                }
                Person coach = team.getMemberAsCoach();
                if (!Objects.isNull(coach)) {
                    Date date;
                    String email;
                    if (coach.getPersonId() == null) {
                        personRepository.save(coach);
                        date = coach.getBirthdate();
                        email = coach.getEmail();
                    } else {
                        Optional<Person> optCoach = personRepository.findById(coach.getPersonId());
                        date = optCoach.get().getBirthdate();
                        email = optCoach.get().getEmail();
                    }

                    int dateThen = date.getYear();
                    Date d = new Date();
                    int dateNow = d.getYear();
                    int age = dateNow - dateThen;
                    if (age < 24)
                        cnt++;
                    allMemebers.add(email);
                }

                int capacity = contest.get().getCapacity();
                System.out.println("capacity " + capacity);
                System.out.println("member size : " + allMemebers.size());
                System.out.println("count  " + cnt);
                System.out.println("flag " + flag);
                System.out.println("teams " + noOfTeams);
                System.out.println("Contest id " + contestId);
                if(capacity <= noOfTeams)
                    return  "Does not have any capacity";
                if(flag == false)
                    return "Member already exists in another team of the same contest.";
                if(cnt != 4)
                    return "Not all members' age are less than 24";
                if(allMemebers.size() != 4)
                    return  "Not all members are distinct";

                if (capacity > noOfTeams && flag == true && cnt == 4 && allMemebers.size() == 4) {
                    team.setContestForTeams(contest.get());
                    team.setState("Pending");
                    for (Person p : team.getMembers()) {
                        if (p.getPersonId() == null)
                            personRepository.save(p);
                    }

                    registerTeam = teamRepository.save(team);
                }
            }
        }
        return  null;
       // return registerTeam;
    }

    public Team editTeam(Team team)
    {
        Optional<Team> optTeam = teamRepository.findById(team.getTeamId());
        Team updateTeam = new Team();

            if(optTeam.isPresent())
            {
                Contest contest = optTeam.get().getContestForTeams();
                if(contest.isWritable())
                {
                    //team.setTeamId(id);
                    updateTeam = teamRepository.save(team);
                }
            }

        return updateTeam;
    }


//    public Team promotion(Long contestId, Long teamId) {
//        Team newTeam = new Team();
////        Long teamId = promoteTeam.getTeamId();
////        Long contestId = promoteTeam.getContestId();
//        Optional<Contest> contest = contestRepository.findById(contestId);
//        Optional<Team> optTeam = teamRepository.findById(teamId);
//        ContestRegister c = new ContestRegister();
//        if(optTeam.isPresent())
//        {
//            int rank = optTeam.get().getRank();
//            if(contest.isPresent()) {
//                Contest superContest = contest.get().getSuperContest();
//                Long superId = superContest.getContestId();
//                c.setContestId(superId);
//                if (rank < 6) {
//                    Team t = optTeam.get();
//                    Team another = new Team();
//                    List<Person> member = t.getMembers();
//                    List<Person> anotherMember = new ArrayList<>();
//                    for(Person p : member)
//                    {
//                        anotherMember.add(p);
//                    }
//                    another.setMembers(anotherMember);
//                    another.setMemberAsCoach(t.getMemberAsCoach());
//                    another.setState(t.getState());
//                    another.setRank(t.getRank());
//                    another.setName(t.getName());
//                    another.setContestForTeams(t.getContestForTeams());
//                   // t.setTeamId(null);
//                    c.setTeam(another);
//                   //newTeam =  contestRegistration(c);
//                }
//            }
//        }
//        return  newTeam;
//    }

    public String promotion(Long contestId, Long teamId) {
        Team newTeam = new Team();
        String str= "";
//        Long teamId = promoteTeam.getTeamId();
//        Long contestId = promoteTeam.getContestId();
        Optional<Contest> contest = contestRepository.findById(contestId);
        Optional<Team> optTeam = teamRepository.findById(teamId);
        ContestRegister c = new ContestRegister();
        if(optTeam.isPresent())
        {
            int rank = optTeam.get().getRank();
            if(rank >=6)
                return "rank is greater than 5";
            if(contest.isPresent()) {
//                Contest superContest = contest.get().getSuperContest();
//                Long superId = superContest.getContestId();
//                c.setContestId(superId);
                if (rank < 6) {
                    Team t = optTeam.get();
                    Team another = new Team();
                    List<Person> member = t.getMembers();
                    List<Person> anotherMember = new ArrayList<>();
                    for(Person p : member)
                    {
                        anotherMember.add(p);
                    }
                    another.setMembers(anotherMember);
                    another.setMemberAsCoach(t.getMemberAsCoach());
                    another.setState(t.getState());
                    another.setRank(t.getRank());
                    another.setName(t.getName());
                    another.setContestForTeams(t.getContestForTeams());
                    // t.setTeamId(null);
                    //c.setTeam(another);
                    str = contestRegistration(contestId, another);
                }
            }
        }
        return  str;
    }
}

