package ua.mk.fedirchyk.services.publisher;

import ua.mk.fedirchyk.controllers.publishercontroller.CreatePublisherRequest;
import ua.mk.fedirchyk.entity.Publisher;

import java.util.List;

public interface PublisherService {

    Publisher create(CreatePublisherRequest p);

    Publisher update(CreatePublisherRequest p);

    int delete(Publisher p);

    List<Publisher> findAll();

    Publisher find(Long id);
}
