package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExists;
import com.stackroute.muzixapp.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("track")
public class MuzixAppController {
    MuzixService muzixService;

    public MuzixAppController() {
    }
    @Autowired
    public MuzixAppController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    @PostMapping("save")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            muzixService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }catch (TrackAlreadyExists e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("get")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(muzixService.displayAllTracks(),HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable Integer id){
        ResponseEntity responseEntity;
        try {
            muzixService.removeTrack(id);
            responseEntity = new ResponseEntity("Suceessfully removed", HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PostMapping("/byname/{trackname}")
    public ResponseEntity<?> trackByName(@PathVariable String trackname) {
        ResponseEntity responseEntity;

        try {
            List<Track> t = muzixService.trackByName(trackname);
            responseEntity = new ResponseEntity<>(t, HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

}
