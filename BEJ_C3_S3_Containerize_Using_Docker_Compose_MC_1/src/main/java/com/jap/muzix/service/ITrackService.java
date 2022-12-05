package com.jap.muzix.service;

import com.jap.muzix.domain.Track;
import com.jap.muzix.exception.TrackExistsException;
import com.jap.muzix.exception.TrackNotFoundException;

import java.util.List;

public interface ITrackService {

    Track saveTrack(Track track) throws TrackExistsException;

    List<Track> getAllTracks();

    List<Track> getAllTracksByArtistName(String name) ;

    List<Track> getAllTracksWithRating(int rating);

    boolean deleteTrackById(int id) throws TrackNotFoundException;
}
