package ua.mk.fedirchyk.repositories.publisher;

import ua.mk.fedirchyk.entity.Publisher;

import java.util.List;

public interface PublisherRepository {


    Publisher create(Publisher p);

    Publisher update(Publisher p);

    int delete(Publisher p);

    List<Publisher> findAll();

    Publisher find(Long id);

}
