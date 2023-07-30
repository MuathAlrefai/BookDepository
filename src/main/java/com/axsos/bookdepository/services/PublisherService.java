package com.axsos.bookdepository.services;


import com.axsos.bookdepository.models.Publisher;
import com.axsos.bookdepository.repositories.PublisherRepository;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher createPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id){
        publisherRepository.deleteById(id);
    }


    public List<Publisher> allPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher findPublisher(Long id){
        Optional<Publisher> optionalPublisher = publisherRepository.findById(id);
        if (optionalPublisher.isPresent()) {
            return optionalPublisher.get();
        }else {
            return null;
        }
    }
}
