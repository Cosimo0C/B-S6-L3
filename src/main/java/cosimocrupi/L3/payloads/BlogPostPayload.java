package cosimocrupi.L3.payloads;

import cosimocrupi.L3.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class BlogPostPayload {
    private UUID authorId;
    private String title;
    private String content;
    private Categoria categoria;
    private LocalDate timeRead;

    @Override
    public String toString() {
        return "BlogPostPayload{" +
                "authorId=" + authorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", categoria=" + categoria +
                ", timeRead=" + timeRead +
                '}';
    }
}
