package cosimocrupi.L3.repositories;

import cosimocrupi.L3.entities.Author;
import cosimocrupi.L3.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BlogPostRepository extends JpaRepository<BlogPost, UUID> {
    List<BlogPost> findByAuthor(Author author);
}
