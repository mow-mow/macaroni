package info.caprese.macaroni.model;

import info.caprese.macaroni.service.Pasta;
import info.caprese.macaroni.service.PastaPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastaRepository extends JpaRepository<Pasta, PastaPk> {
}
