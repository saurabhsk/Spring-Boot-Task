package com.stackroute.MuzixApp.service.service;

import com.stackroute.MuzixApp.service.domain.Muzix;
import com.stackroute.MuzixApp.service.exception.MuzixAlreadyExistException;
import com.stackroute.MuzixApp.service.exception.MuzixNotFoundException;
import com.stackroute.MuzixApp.service.exception.MuzixTrackNotFoundException;

import java.util.List;

//MuzixService Interface having methods to be implemented by MuzixServiceImpl class

public interface MuzixService {

    public Muzix saveMuzix(Muzix muzix) throws MuzixAlreadyExistException;

    public Muzix updateTrack(Muzix muzix) throws MuzixTrackNotFoundException;

    public List<Muzix> getAllTracks();

    public List<Muzix> getTracksByName(String trackName)throws MuzixNotFoundException;

    public Muzix getTrackById(int id);

    public void removeById(int id);
}
