package com.stackroute.MuzixApp.service.service;


import com.stackroute.MuzixApp.service.domain.Muzix;
import com.stackroute.MuzixApp.service.repository.MuzixRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixService {

    private MuzixRepo muzixRepo;

    @Autowired
    public MuzixService(MuzixRepo muzixRepo) {
        this.muzixRepo = muzixRepo;
    }

    public Muzix saveMuzix(Muzix muzix) {
        Muzix savedtrack = muzixRepo.save(muzix);
        return savedtrack;

    }

    public Muzix updateTrack(Muzix muzix) {
        Muzix updatetrack = muzixRepo.save(muzix);
        return updatetrack;

    }

    public List<Muzix> getAllTracks() {
        return muzixRepo.findAll();

    }

    public Muzix getTrackById(int id) {
        Optional<Muzix> muzix = muzixRepo.findById(id);
        return muzix.get();

    }

    public void removeById(int id) {
        muzixRepo.deleteById(id);
    }
}
