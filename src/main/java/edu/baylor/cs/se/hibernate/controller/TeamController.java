package edu.baylor.cs.se.hibernate.controller;
import edu.baylor.cs.se.hibernate.model.ContestRegister;
import edu.baylor.cs.se.hibernate.model.Person;
import edu.baylor.cs.se.hibernate.model.PromoteTeam;
import edu.baylor.cs.se.hibernate.model.Team;
import edu.baylor.cs.se.hibernate.services.PersonService;
import edu.baylor.cs.se.hibernate.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamController {
    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {this.teamService = teamService; }

    @PostMapping("/team")
    public ResponseEntity createTeam(@RequestBody Team team)
    {
        teamService.createTeam(team);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/allteams", method = RequestMethod.GET)
    public ResponseEntity<Team> getTeams(){
        return new ResponseEntity(teamService.getAllTeam(),HttpStatus.OK);
    }

    @GetMapping("team/{id}")
    public Team teamById(@PathVariable("id") Long id) {
        return teamService.teamById(id);
    }

//    @PostMapping("/rule1")
//    public ResponseEntity contestRegistration(@RequestParam(value = "contestId", required = false) Long contestId,
//                                              @RequestBody Team team)
//    {
//       Long id = teamService.contestRegistration(contestId, team).getTeamId();
//       if(id != null)
//          return new ResponseEntity(HttpStatus.OK);
//       else
//           return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team can not be registered as rule violated.");
//
//    }

    @PostMapping("/contestsRegistration")
    public ResponseEntity contestRegistration(@RequestParam(value = "contestId", required = false) Long contestId,
                                              @RequestBody Team team)
    {
       // Long id = teamService.contestRegistration(contestId, team).getTeamId();
        String err = teamService.contestRegistration(contestId, team);
        if(err == null)
            return new ResponseEntity(HttpStatus.OK);
        else
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }
    @PutMapping("/editTeam")
    public ResponseEntity editTeam(@RequestBody Team team)
    {
        Long id = teamService.editTeam(team).getTeamId();
        if(id != null)
            return new ResponseEntity(HttpStatus.OK);
        else
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can not edit this team.");
    }

    @PostMapping("/promote")
    public ResponseEntity promotion(@RequestParam(value = "superContestId", required = false) Long contestId,
                                    @RequestParam(value = "teamId", required = false) Long teamId)
    {
        String err = teamService.promotion(contestId, teamId);
        if(err == null)
            return new ResponseEntity(HttpStatus.OK);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
