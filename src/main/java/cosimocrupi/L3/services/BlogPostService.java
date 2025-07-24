package cosimocrupi.L3.services;

import cosimocrupi.L3.entities.Author;
import cosimocrupi.L3.entities.BlogPost;
import cosimocrupi.L3.exceptions.NotFoundException;
import cosimocrupi.L3.payloads.BlogPostPayload;
import cosimocrupi.L3.repositories.BlogPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private AuthorService authorService;

    public BlogPost saveBlog(BlogPostPayload payload){
        Author author=authorService.findById(payload.getAuthorId());
        BlogPost b1 =new BlogPost(payload.getTitle(), payload.getContent(),payload.getCategoria(), payload.getTimeRead());
        b1.setCover("https://picsum.photos/200/300");
        b1.setAuthor(author);
        return blogPostRepository.save(b1);
    }
    public List<BlogPost> getBlogs(){
        return blogPostRepository.findAll();
    }
    public BlogPost finById(UUID blogId){
        return blogPostRepository.findById(blogId).orElseThrow(()->new NotFoundException(blogId));
    }
    public void findByIdAndDelete(UUID blogId){
        BlogPost fnd=this.finById(blogId);
        blogPostRepository.delete(fnd);
    }
    public BlogPost findByIdAndUpdate(UUID blogId, BlogPostPayload payload){
        BlogPost fnd= this.finById(blogId);
        fnd.setTitle(payload.getTitle());
        fnd.setContent(payload.getContent());
        fnd.setTimeRead(payload.getTimeRead());

        if (fnd.getAuthor().getId()!= payload.getAuthorId()) {
            Author newA= authorService.findById(payload.getAuthorId());
            fnd.setAuthor(newA);
        }
        return blogPostRepository.save(fnd);
    }
    public List<BlogPost> findByAuthor(UUID authorId){
        Author a= authorService.findById(authorId);
        return blogPostRepository.findByAuthor(a);
    }
}
