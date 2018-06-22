package ua.mk.fedirchyk.services.publisher;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.fedirchyk.controllers.publishercontroller.CreatePublisherRequest;
import ua.mk.fedirchyk.entity.Publisher;
import ua.mk.fedirchyk.repositories.publisher.PublisherRepository;

import java.util.List;

@Service
@Transactional
public class BookPublisherDefaultService implements PublisherService {
    private final PublisherRepository publisherRepository;

    public BookPublisherDefaultService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher create(CreatePublisherRequest publisher) {
        //TODO: Make real logic
        Publisher p = new Publisher();
        p.setNamePublisher(publisher.getNamePublisher());
        p.setCountry(publisher.getCountry());
        p.setDescription(publisher.getDescription());
        return publisherRepository.create(p);
    }

    @Override
    public Publisher update(CreatePublisherRequest p) {
        //TODO: Make real logic
        Publisher publisher = new Publisher();
        return publisherRepository.update(publisher);
    }

    @Override
    public int delete(Publisher p) {
        return 0;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher find(Long id) {
        return publisherRepository.find(id);
    }
}
