package cosimocrupi.L3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class Author {
    @Setter(AccessLevel.NONE)
    protected UUID id;
    protected String name;
    protected String surname;
    protected String email;
    protected String cover;
    protected LocalDate dataDiNascita;

    public Author(String name, String surname, String email, LocalDate dataDiNascita) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
    }
}
