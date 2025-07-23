package cosimocrupi.L3.repositories;

import cosimocrupi.L3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    List<Author> findByDataDiNascita(LocalDate dataDiNascita);
    Optional<Author> findByEmail (String email);
}
