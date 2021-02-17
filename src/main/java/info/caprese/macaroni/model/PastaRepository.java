package info.caprese.macaroni.model;

import info.caprese.macaroni.service.Pasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastaRepository extends JpaRepository<Pasta, String> {
}
