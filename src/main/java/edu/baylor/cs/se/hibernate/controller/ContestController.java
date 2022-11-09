package edu.baylor.cs.se.hibernate.controller;
import edu.baylor.cs.se.hibernate.model.Contest;
import edu.baylor.cs.se.hibernate.model.Team;
import edu.baylor.cs.se.hibernate.services.ContestService;
import edu.baylor.cs.se.hibernate.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ContestController {
    private ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {this.contestService = contestService; }

    @RequestMapping(value = "/populate", method = RequestMethod.GET)
    public ResponseEntity populate(){
        contestService.populate();
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/contest")
    public ResponseEntity createContest(@RequestBody Contest contest)
    {
        contestService.createContest(contest);
        return new ResponseEntity(HttpStatus.OK);
    }

   // @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/allContest", method = RequestMethod.GET)
    public ResponseEntity<Team> getContest(){
        return new ResponseEntity(contestService.getAllContest(),HttpStatus.OK);
    }

    @GetMapping("contest/{id}")
    public Contest contestById(@PathVariable("id") Long id) {
        return contestService.contestById(id);
    }

    @PatchMapping("/editContest")
    public ResponseEntity editContest(@RequestBody Contest contest)
    {
        Long id = contestService.editContest(contest).getContestId();
        if(id != null)
            return new ResponseEntity(HttpStatus.OK);
        else
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can not edit this contest.");
    }

    @PostMapping("/setEditable")
    public ResponseEntity setContest(@RequestParam(value = "contestId", required = false) Long id)
    {
        int i = contestService.setContest(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/setReadonly")
    public ResponseEntity setReadonly(@RequestParam(value = "contestId", required = false) Long id)
    {
        int i = contestService.setReadonly(id);
        return new ResponseEntity(HttpStatus.OK);
    }



//    @PutMapping("/setReadonly/{id}")
//    public Contest setReadonly(@PathVariable("id") Long id, @RequestBody Contest contest)
//    {
//        return contestService.setReadonly(id, contest);
//    }


}
