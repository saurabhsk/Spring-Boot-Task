package com.stackroute.MuzixApp.service.service;


import com.stackroute.MuzixApp.service.domain.Muzix;
import com.stackroute.MuzixApp.service.exception.MuzixAlreadyExistException;
import com.stackroute.MuzixApp.service.exception.MuzixNotFoundException;
import com.stackroute.MuzixApp.service.exception.MuzixTrackNotFoundException;
import com.stackroute.MuzixApp.service.repository.MuzixRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//class that implements the methods of MuzixService Interface

@Service
public class MuzixServiceImpl implements MuzixService {

    private MuzixRepo muzixRepo;


    @Autowired
    public MuzixServiceImpl(MuzixRepo muzixRepo) {
        this.muzixRepo = muzixRepo;
    }


    //Method to return saveedtrack and handle exception
    public Muzix saveMuzix(Muzix muzix) throws MuzixAlreadyExistException {
        if (muzixRepo.existsById(muzix.getTrackId())) {

            throw new MuzixAlreadyExistException("Track Already present");
        }
        Muzix savedtrack = muzixRepo.save(muzix);

        return savedtrack;

    }

    //Method to return updatedtrack

    public Muzix updateTrack(Muzix muzix) throws MuzixTrackNotFoundException {
        if (!muzixRepo.existsById(muzix.getTrackId())) {

            throw new MuzixTrackNotFoundException("Muzix Track Not Found");
        }
        Muzix updatetrack = muzixRepo.save(muzix);
        return updatetrack;

    }


    //Method to return list of all the saved tracks
    public List<Muzix> getAllTracks() {
        return muzixRepo.findAll();

    }


    //Method to return data using trackName
    public List<Muzix> getTracksByName(String trackName) throws MuzixNotFoundException {
        if (muzixRepo.findByTrackName(trackName).isEmpty()) {
            throw new MuzixNotFoundException("Track Not found ");
        }
        return muzixRepo.findByTrackName(trackName);

    }


    //Method to return data using trackId
    public Muzix getTrackById(int id) {
        Optional<Muzix> muzix = muzixRepo.findById(id);
        return muzix.get();

    }


    //Method to delete data using id
    public void removeById(int id) {
        muzixRepo.deleteById(id);
    }
}

