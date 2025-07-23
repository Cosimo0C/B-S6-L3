package cosimocrupi.L3.services;

import cosimocrupi.L3.entities.Author;
import cosimocrupi.L3.exceptions.BadRequestException;
import cosimocrupi.L3.payloads.AuthorPayload;
import cosimocrupi.L3.repositories.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author save(AuthorPayload payload){
        this.authorRepository.findByEmail(payload.getEmail()).ifPresent(author -> {throw new BadRequestException("L'email " + author.getEmail() + " è già in uso!");
    });
        Author a1 = new Author(payload.getName(), payload.getSurname(), payload.getEmail(), payload.getDataDiNascita());
        Author saveAuthor= this.authorRepository.save(a1);
        log.info("Salvato correttamente");
        return saveAuthor;
    }
}
