package info.caprese.macaroni.model;

import info.caprese.macaroni.service.PastaM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PastaMRepository extends JpaRepository<PastaM, Integer> {
    @Query(value = "SELECT * FROM pasta_m ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<PastaM> findPastaMRandom();
}
