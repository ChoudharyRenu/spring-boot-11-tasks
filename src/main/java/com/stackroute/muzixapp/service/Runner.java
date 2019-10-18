package com.stackroute.muzixapp.service;
import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private MuzixService muzixService;
    private Environment environment;
    public Runner(@Autowired MuzixService muzixService, @Autowired Environment environment) {
        this.muzixService = muzixService;
        this.environment = environment;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("here");
        Track track = new Track(444, environment.getProperty("in.name"), environment.getProperty("in.comment"));
        try {
            muzixService.saveTrack(track);
        } catch(TrackAlreadyExists trackAlreadyExists) {
            muzixService.updateTrack(track.getTrackId(),track);
        }
    }
}