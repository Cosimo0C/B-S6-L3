package cosimocrupi.L3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class BlogPost {
    @Setter(AccessLevel.NONE)
    protected UUID id;
    protected String title;
    protected String content;
    protected String cover;
    protected LocalDate timeRead;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public BlogPost(UUID id, String title, String content, String cover, LocalDate timeRead) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.cover = cover;
        this.timeRead = timeRead;
    }
}
