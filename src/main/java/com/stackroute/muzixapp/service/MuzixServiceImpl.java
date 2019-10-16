package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExists;
import com.stackroute.muzixapp.exceptions.TrackNotFound;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MuzixServiceImpl implements MuzixService {
    MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }


    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExists {
        if(muzixRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExists("Track already exists");
        }
        Track saveTrack = muzixRepository.save(track);
        if(saveTrack == null){
            throw new TrackAlreadyExists("Track already exists");
        }
        return saveTrack;
    }

    @Override
    public List<Track> displayAllTracks() {
        return muzixRepository.findAll();
    }

    @Override
    public boolean updateTrack(int trackId,Track track) throws TrackNotFound {
        if(track==null){
            throw new TrackNotFound("Track Not Found");
        }
        track.setTrackId(trackId);
            return true;
    }
    @Override
    public boolean removeTrack(int trackId) throws TrackNotFound{
        if(muzixRepository.existsById(trackId)==false){
            throw new TrackNotFound("Track not found");
        }
        muzixRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Track> trackByName(String name) {
        return muzixRepository.findAllTracksByName(name);
    }



}
