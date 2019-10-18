package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExists;
import com.stackroute.muzixapp.exceptions.TrackNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Listener implements ApplicationListener<ContextRefreshedEvent> {
    private MuzixService muzixService;
    @Autowired
    public Listener(MuzixService muzixService){
        this.muzixService = muzixService;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            muzixService.saveTrack(new Track(22, "Listener", "comment"));
        } catch (TrackAlreadyExists muzixAlreadyExists) {
            try {
                muzixService.updateTrack(1,new Track(22, "Listener", "comment"));
            } catch (TrackNotFound e) {
                System.out.println("hello");
            }
        }
    }
}
