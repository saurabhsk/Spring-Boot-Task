package com.stackroute.MuzixApp.service.controller;

import com.stackroute.MuzixApp.service.domain.Muzix;
import com.stackroute.MuzixApp.service.exception.MuzixTrackNotFoundException;
import com.stackroute.MuzixApp.service.service.MuzixServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Controller Class
@RestController
@RequestMapping("api/v1")


public class MuzixController {

    private MuzixServiceImpl muzixServiceImpl;   //MuzixServiceImpl object

    @Autowired
    public MuzixController(MuzixServiceImpl muzixServiceImpl) {  //constructor to Autowire muzixService Object

        this.muzixServiceImpl = muzixServiceImpl;
    }

    @PostMapping("/muzix")   //To create data in database
    public ResponseEntity<Muzix> saveMuzix(@RequestBody Muzix muzix) throws Exception {

        Muzix savedMuzix = muzixServiceImpl.saveMuzix(muzix);
        return new ResponseEntity<>(savedMuzix, HttpStatus.CREATED);
    }

    @PutMapping("/muzix/{id}")  //To update data in database using id
    public ResponseEntity<Muzix> updateTrack(@RequestBody Muzix muzix, @PathVariable int id) throws MuzixTrackNotFoundException {
        muzix.setTrackId(id);
        Muzix updatetrack = muzixServiceImpl.updateTrack(muzix);
        return new ResponseEntity<Muzix>(updatetrack, HttpStatus.OK);
    }

    @GetMapping("/muzix/list")   //To get all the data in database
    public ResponseEntity<List<Muzix>> getAllMuzix() {

        List<Muzix> allmuzix = muzixServiceImpl.getAllTracks();
        return new ResponseEntity<>(allmuzix, HttpStatus.OK);

    }

    @GetMapping("/muzix/muzixsby/{trackname}") //To get data in database using trackname
    public ResponseEntity<?> getAllMuzixTrack(@PathVariable String trackname) throws Exception {
        List<Muzix> allmuzix = null;

        allmuzix = muzixServiceImpl.getTracksByName(trackname);

        return new ResponseEntity<>(allmuzix, HttpStatus.OK);

    }

    @GetMapping("/muzix/muzixs/{id}") //To get data from database using id
    public ResponseEntity<Muzix> getMuzixById(@PathVariable int id) {
        Muzix muzixById = muzixServiceImpl.getTrackById(id);
        return new ResponseEntity<Muzix>(muzixById, HttpStatus.OK);
    }

    @DeleteMapping("/muzix/muzixse/{id}")  //To delete data using id

    public String removeTrack(@PathVariable int id) {
        muzixServiceImpl.removeById(id);
         return "Data Deleted Successfully!!";
    }


}
