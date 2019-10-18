package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExists;
import com.stackroute.muzixapp.exceptions.TrackNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import java.util.List;
@Primary
public class DummyImpl implements MuzixService {
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExists {
        return null;
    }

    @Override
    public List<Track> displayAllTracks() {
        return null;
    }

    @Override
    public boolean updateTrack(int trackId, Track track) throws TrackNotFound {
        return false;
    }

    @Override
    public boolean removeTrack(int trackId) throws TrackNotFound {
        return false;
    }

    @Override
    public List<Track> trackByName(String name) {
        return null;
    }
}
