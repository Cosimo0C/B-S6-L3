package cosimocrupi.L3.controllers;

import cosimocrupi.L3.entities.Author;
import cosimocrupi.L3.entities.BlogPost;
import cosimocrupi.L3.payloads.AuthorPayload;
import cosimocrupi.L3.payloads.BlogPostPayload;
import cosimocrupi.L3.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/blogpost")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost save(@RequestBody BlogPostPayload payload){
        return this.blogPostService.saveBlog(payload);
    }

    @GetMapping("/{authorId}")
    public BlogPost getById(@PathVariable UUID blogId){
        return this.blogPostService.finById(blogId);
    }
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getByIdAndDelete(@PathVariable UUID blogID){
        this.blogPostService.findByIdAndDelete(blogID);
    }
}
