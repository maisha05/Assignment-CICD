package edu.baylor.cs.se.hibernate.repository;

import edu.baylor.cs.se.hibernate.model.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContestRepository extends JpaRepository<Contest,Long> {
    @Modifying
    @Query(nativeQuery = true, value = "update Contest set WRITABLE = true where contest_id = :contestId")
    int setWritable(@Param("contestId") Long contestId);

    @Modifying
    @Query(nativeQuery = true, value = "update Contest set WRITABLE = false where contest_id = :contestId")
    int setReadonly(@Param("contestId") Long contestId);
}
