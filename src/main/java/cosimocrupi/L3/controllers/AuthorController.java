package cosimocrupi.L3.controllers;

import cosimocrupi.L3.entities.Author;
import cosimocrupi.L3.payloads.AuthorPayload;
import cosimocrupi.L3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody AuthorPayload payload){
        return this.authorService.save(payload);
    }

    @GetMapping("/{authorId}")
    public Author getById(@PathVariable UUID authorId){
        return this.authorService.findById(authorId);
    }
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getByIdAndDelete(@PathVariable UUID authorID){
        this.authorService.findByIdAndDelete(authorID);
    }
}
