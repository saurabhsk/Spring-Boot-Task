package com.stackroute.MuzixApp.service.repository;

import com.stackroute.MuzixApp.service.domain.Muzix;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuzixRepo extends MongoRepository<Muzix, String> {

    List<Muzix> findByTrackName(String trackName);  // creating custom method to find Data by trackName
}
