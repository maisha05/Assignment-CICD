package edu.baylor.cs.se.hibernate.repository;

import edu.baylor.cs.se.hibernate.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TeamRepository extends JpaRepository<Team,Long> {
}
