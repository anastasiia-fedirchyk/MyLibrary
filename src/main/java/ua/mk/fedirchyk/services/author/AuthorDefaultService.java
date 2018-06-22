package ua.mk.fedirchyk.services.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.fedirchyk.controllers.authorcontroller.CreateAuthorRequest;
import ua.mk.fedirchyk.entity.Author;
import ua.mk.fedirchyk.repositories.author.AuthorRepository;

import java.time.ZoneId;
import java.util.List;

@Service
@Transactional
public class AuthorDefaultService implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorDefaultService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(CreateAuthorRequest author) {
        Author a = new Author();
        a.setFirstName(author.getFirstName());
        a.setLastName(author.getLastName());
        a.setBirthDate(author.getBirthDate().atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond());

        return authorRepository.create(a);
    }

    @Override
    public Author update(CreateAuthorRequest author) {
        Author a = new Author();
        a.setFirstName(author.getFirstName());
        a.setLastName(author.getLastName());
        a.setBirthDate(author.getBirthDate().atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond());

        return authorRepository.update(a);
    }

    @Override
    public int delete(Author a) {
        return authorRepository.delete(a);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author find(Long id) {
        return authorRepository.find(id);
    }
}
