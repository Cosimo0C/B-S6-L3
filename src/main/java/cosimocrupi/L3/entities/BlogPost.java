package cosimocrupi.L3.entities;

import cosimocrupi.L3.enums.Categoria;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class BlogPost {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    protected UUID id;
    protected String title;
    protected String content;
    protected Categoria categoria;
    protected String cover;
    protected LocalDate timeRead;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public BlogPost(String title, String content,Categoria categoria, LocalDate timeRead) {
        this.title = title;
        this.content = content;
        this.timeRead = timeRead;
    }
}
