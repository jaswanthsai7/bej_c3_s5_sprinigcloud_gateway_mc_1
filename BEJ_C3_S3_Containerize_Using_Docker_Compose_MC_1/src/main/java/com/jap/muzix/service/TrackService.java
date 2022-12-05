/*
 * Author Name : Jaswanth Sai
 * Date : 11/24/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.jap.muzix.service;

import com.jap.muzix.domain.Track;
import com.jap.muzix.exception.TrackExistsException;
import com.jap.muzix.exception.TrackNotFoundException;
import com.jap.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrackService implements ITrackService{

    private TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @Override
    public Track saveTrack(Track track) throws TrackExistsException {
        if (trackRepository.findById(track.getTrackId()).isPresent()){
            throw new TrackExistsException();
        }else {
            return this.trackRepository.save(track);
        }
    }

    @Override
    public List<Track> getAllTracks() {
        return this.trackRepository.findAll();
    }

    @Override
    public List<Track> getAllTracksByArtistName(String name) {
        return this.trackRepository.findAllTrackArtistName(name);
    }

    @Override
    public List<Track> getAllTracksWithRating(int rating) {
        return this.trackRepository.findByTrackRatingGreaterThan(rating);
    }

    @Override
    public boolean deleteTrackById(int id) throws TrackNotFoundException {
        boolean flag= false;
        if(trackRepository.existsById(id)) {
            trackRepository.deleteById(id);
            flag= true;
        }else {
            throw new TrackNotFoundException();
        }
        return flag;
    }
}
