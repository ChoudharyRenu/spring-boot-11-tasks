package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExists;
import com.stackroute.muzixapp.exceptions.TrackNotFound;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public interface MuzixService {
    public Track saveTrack(Track track) throws TrackAlreadyExists;
    public List<Track> displayAllTracks();
    public boolean updateTrack(int trackId,Track track) throws TrackNotFound;
    public boolean removeTrack(int trackId) throws TrackNotFound;
    public List<Track> trackByName(String name);
}
