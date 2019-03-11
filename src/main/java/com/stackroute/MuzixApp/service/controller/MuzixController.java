package com.stackroute.MuzixApp.service.controller;

import com.stackroute.MuzixApp.service.domain.Muzix;
import com.stackroute.MuzixApp.service.service.MuzixService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MuzixController {

    private MuzixService muzixService;

    @Autowired
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    @PostMapping("/muzix")
    public ResponseEntity<Muzix> saveMuzix(@RequestBody Muzix muzix){
        Muzix savedMuzix = muzixService.saveMuzix(muzix);
        return new ResponseEntity<Muzix>(savedMuzix, HttpStatus.OK);
    }

    @PutMapping("/muzix/{id}")
    public ResponseEntity<Muzix>updateTrack(@RequestBody Muzix muzix,@PathVariable int id){
        muzix.setTrackId(id);
        Muzix updatetrack = muzixService.updateTrack(muzix);
        return  new ResponseEntity<Muzix>(updatetrack,HttpStatus.OK);
    }

    @GetMapping("/muzixs")
    public ResponseEntity<List<Muzix>> getAllMuzix(){
        List<Muzix> allmuzix = muzixService.getAllTracks();
        return new ResponseEntity<>(allmuzix,HttpStatus.OK);
    }

    @GetMapping("/muzixs/{id}")
    public ResponseEntity<Muzix>getMuzixById(@PathVariable int id){
        Muzix muzixById = muzixService.getTrackById(id);
        return new ResponseEntity<Muzix>(muzixById,HttpStatus.OK);
    }

    @GetMapping("/muzixse/{id}")

    public void removeTrack(@PathVariable int id){
         muzixService.removeById(id);

    }
}
