package com.stackroute.MuzixApp.service.controller;

import com.stackroute.MuzixApp.service.domain.Muzix;
import com.stackroute.MuzixApp.service.exception.MuzixAlreadyExistException;
import com.stackroute.MuzixApp.service.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")


public class MuzixController implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

    private MuzixService muzixService;

    @Autowired
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    @PostMapping("/muzix")
    public ResponseEntity<Muzix> saveMuzix(@RequestBody Muzix muzix) throws Exception {
//        try {
        Muzix savedMuzix = muzixService.saveMuzix(muzix);
        return new ResponseEntity<>(savedMuzix, HttpStatus.OK);
//        } catch (MuzixAlreadyExistException ex) {
//            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//        }
    }

    @PutMapping("/muzix/{id}")
    public ResponseEntity<Muzix> updateTrack(@RequestBody Muzix muzix, @PathVariable int id) {
        muzix.setTrackId(id);
        Muzix updatetrack = muzixService.updateTrack(muzix);
        return new ResponseEntity<Muzix>(updatetrack, HttpStatus.OK);
    }

    @GetMapping("/muzix/list")
    public ResponseEntity<List<Muzix>> getAllMuzix() {

        List<Muzix> allmuzix = muzixService.getAllTracks();
        return new ResponseEntity<>(allmuzix, HttpStatus.OK);

    }

    @GetMapping("/muzix/muzixsby/{trackname}")
    public ResponseEntity<?> getAllMuzixTrack(@PathVariable String trackname) throws Exception {
        List<Muzix> allmuzix = null;
        //try {
        allmuzix = muzixService.getTracksByName(trackname);
//        } catch (MuzixNotFoundException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//        }
        return new ResponseEntity<>(allmuzix, HttpStatus.OK);

    }

    @GetMapping("/muzix/muzixs/{id}")
    public ResponseEntity<Muzix> getMuzixById(@PathVariable int id) {
        Muzix muzixById = muzixService.getTrackById(id);
        return new ResponseEntity<Muzix>(muzixById, HttpStatus.OK);
    }

    @GetMapping("/muzix/muzixse/{id}")

    public void removeTrack(@PathVariable int id) {
        muzixService.removeById(id);

    }

    @Value("${trackName1}")
    String name1;
    @Value("${comment1}")
    String comment1;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Muzix muzix = new Muzix(1, name1, comment1);
        try {
            muzixService.saveMuzix(muzix);
        } catch (MuzixAlreadyExistException e) {
            e.printStackTrace();
        }
    }

    @Value("${trackName2}")
    String name2;
    @Value("${comment2}")
    String comment2;

    @Override
    public void run(String... args) throws Exception {

        Muzix muzix = new Muzix(0, name2, comment2);
        try {
            muzixService.saveMuzix(muzix);
        } catch (MuzixAlreadyExistException e) {
            e.printStackTrace();
        }
    }
}
