package cosimocrupi.L3.services;

import cosimocrupi.L3.entities.Author;
import cosimocrupi.L3.exceptions.BadRequestException;
import cosimocrupi.L3.exceptions.NotFoundException;
import cosimocrupi.L3.payloads.AuthorPayload;
import cosimocrupi.L3.repositories.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author save(AuthorPayload payload){
        this.authorRepository.findByEmail(payload.getEmail()).ifPresent(author -> {throw new BadRequestException("L'email " + author.getEmail() + " è già in uso!");
    });
        Author a1 = new Author(payload.getName(), payload.getSurname(), payload.getEmail(), payload.getDataDiNascita());
        a1.setCover("https://ui-avatars.com/api/?name=" + a1.getName() +"+"+ a1.getSurname());
        Author saveAuthor= this.authorRepository.save(a1);
        log.info("Salvato correttamente");
        return saveAuthor;
    }
    public Author findById(UUID authorId){
        return this.authorRepository.findById(authorId).orElseThrow(()-> new NotFoundException(authorId));
    }
    public void findByIdAndDelete(UUID authorId){
        Author fnd= this.findById(authorId);
        this.authorRepository.delete(fnd);
    }
}
